/**
 * OpenApiUtils.java 2011-9-6
 */
package Utils;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * <b>OpenApiUtils</b> OpenApi调用助手类，请注意：<BR/>
 * 1、依赖apache commons httpclient 3
 * 2、依赖apache commons lang或者lang3
 * 3、依赖spring-beans 3.0以上模块，你也可以替换为apache commons beanuitls
 * </p>
 * 
 * @since 2011-9-6
 * @author zhengping_wang
 * @version $Id: OpenApiUtils.java 4847 2014-02-14 07:10:02Z wzp $
 */
public abstract class OpenApiUtils {

	public static final String AJAX_REQUEST_HEADER = "X-Requested-With";

	public static final String API_REQUEST_VALUE = "OpenAPIRequest";

	/**
	 * 组织OpenAPI参数
	 * 
	 * @param appId 在UIM中注册的APP_ID
	 * @param appSecret UIM系统中注册的应用密钥
	 * @param sessionKey CAS系统分配给登录用户的PT
	 * @param version API的版本号，默认不填是1.0
	 * @param format 返回数据的格式，可选json或xml，目前支持json
	 * @param signMethod 数据签名算法，支持md5或hmac，默认是md5
	 * @param postParams 本次请求的POST的参数
	 * @return 所有参数的签名
	 */
	public static String getOpenApiParams(String appId, String appSecret, String sessionKey, String version, String format,
			String signMethod, String locale, NameValuePair[] postParams) {
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("app_key", appId);
		params.put("timestamp", Long.toString((new Date()).getTime()));
		System.out.println("timestamp: " + params.get("timestamp"));
		// 以下是可选参数
		if (StringUtils.isNotEmpty(sessionKey)) {
			params.put("session", sessionKey);
		}
		if (StringUtils.isNotEmpty(version)) {
			params.put("v", version);
		}
		if (StringUtils.isNotEmpty(format)) {
			params.put("format", format);
		}
		if (StringUtils.isNotEmpty(signMethod)) {
			params.put("sign_method", signMethod);
		}
		if (StringUtils.isNotEmpty(locale)) {
			params.put("locale", locale);
		}

		StringBuffer result = new StringBuffer();
		boolean firstParam = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			if (!firstParam) {
				result.append("&");
			}
			firstParam = false;
			result.append(name).append("=").append(value);
		}

		// 业务参数
		if (null != postParams) {
			for (NameValuePair nvp : postParams) {
				params.put(nvp.getName(), nvp.getValue());
			}
		}

		// 对参数签名
		// 密钥是macula_samples在应用表中对应的公钥
		String sign = md5Signature(params, appSecret);
		result.append("&sign").append("=").append(sign);
System.out.println("result.toString():" + result.toString());
		return result.toString();
	}

	/**
	 * 将Bean对象转换成FORM的Name Value 提交
	 * 
	 * @param objectName
	 * @param obj
	 */
	public static NameValuePair[] getPostParams(String objectName, Object obj) {
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (obj != null) {
			if (obj instanceof Map) {
				// 处理Map
				Map<?, ?> map = (Map<?, ?>) obj;
				for (Map.Entry<?, ?> entry : map.entrySet()) {
					Object key = entry.getKey();
					Object value = entry.getValue();
					if (null != value) {
						pairs.addAll(Arrays.asList(getPostParams(objectName + "['" + key + "']", value)));
					}
				}
			} else if (obj instanceof Collection) {
				// 处理Collection
				Collection<?> col = (Collection<?>) obj;
				Iterator<?> it = col.iterator();
				int index = 0;
				while (it.hasNext()) {
					Object value = it.next();
					if (null != value) {
						pairs.addAll(Arrays.asList(getPostParams(objectName + "[" + index++ + "]", value)));
					}
				}
			} else if (!BeanUtils.isSimpleProperty(obj.getClass()) && !(obj instanceof Enum)
					&& !Date.class.isAssignableFrom(obj.getClass())) {
				// 处理Bean
				BeanWrapperImpl bean = new BeanWrapperImpl(obj);
				PropertyDescriptor[] ps = bean.getPropertyDescriptors();
				for (PropertyDescriptor p : ps) {
					if (!p.getName().equals("class")) {
						Object value = bean.getPropertyValue(p.getName());
						if (null != value) {
							pairs.addAll(Arrays.asList(getPostParams(objectName + "." + p.getName(), value)));
						}
					}
				}
			} else {
				String str = obj.toString();
				// 处理简单属性
				// 日期格式使用ISO8601
				if (obj instanceof Date) {
					str = formatISO8601((Date) obj);
				}
				pairs.add(new NameValuePair(objectName, str));
			}
		}
		return pairs.toArray(new NameValuePair[pairs.size()]);
	}

	/**
	 * 按格式输出DateTime到iso8601 string
	 * 
	 * @param date
	 * @return iso 8601 string
	 */
	public synchronized static String formatISO8601(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		return df.format(date);
	}

	/**
	 * 二行制转字符串
	 */
	private static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs.append("0").append(stmp);
			} else {
				hs.append(stmp);
			}
		}
		return StringUtils.upperCase(hs.toString());
	}

	/**
	 * 生产字符串的Md5值
	 * @param context
	 */
	public static String md5(String context) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return byte2hex(md.digest(context.toString().getBytes("UTF-8")));
		} catch (Exception e) {
			throw new RuntimeException("md5 error!", e);
		}
	}

	/**
	 * 新的md5签名，首尾放secret。
	 *
	 * @param params 传给服务器的参数
	 * @param secret 分配给您的APP_SECRET
	 */
	private static String md5Signature(TreeMap<String, String> params, String secret) {
		String result = null;
		StringBuffer orgin = getBeforeSign(params, new StringBuffer(secret));
		if (orgin == null) {
			return result;
		}
		System.out.println("orgin:" + orgin);
		// secret last
		orgin.append(secret);
		System.out.println("orgin2:" + orgin);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
		} catch (Exception e) {
			throw new RuntimeException("md5 sign error !", e);
		}
		return result;
	}

	/**
	 * 添加参数的封装方法
	 * 
	 * @param params
	 * @param orgin
	 * @return
	 */
	private static StringBuffer getBeforeSign(TreeMap<String, String> params, StringBuffer orgin) {
		if (params == null) {
			return null;
		}

		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.putAll(params);
		Iterator<String> iter = treeMap.keySet().iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			orgin.append(name).append(params.get(name));
		}
		return orgin;
	}
}
