package client;

import Utils.ObjectMapperImpl;
import Utils.OpenApiUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import model.UIMOrg;
import model.UIMUser;
import model.vo.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by linjinbo on 2017/9/18.
 */
public class UIMClient {

    // 生产环境以下参数会发生变化
    protected  String endPoint;
    protected  String appKey;
    protected  String appSecret;

    public UIMClient(String endPoint, String appKey, String appSecret){
        this.endPoint = endPoint;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public ExecuteResponse<UIMOrg> readorg(String orgCode) {

        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/org/" + orgCode);
        try {
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", null));
            // 执行请求
            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                return mapper.readValue(content, new TypeReference<ExecuteResponse<UIMOrg>>() {});
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public  ExecuteResponse<Boolean> existorg(String orgCode) {

        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/org/exist/" + orgCode);
        try {
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", null));
            // 执行请求
            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {});
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

//    public  ExecuteResponse<Boolean> saveorg() {
//        UIMOrg org = new UIMOrg();
//        org.setOaId(3L);
//        org.setParentId(1L);
//        org.setCode("MM");
//        org.setEnabled(true);
//        org.setFoundDate(new Date());
//        org.setGroup(true);
//        org.setLeaderAccount("admin");
//        org.setLevel(1);
//        org.setName("物流部");
//        org.setOrdered(1);
//        org.setSimpleName("物流部");
//        org.setType("HO");
//
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/org/save");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.setRequestBody(OpenApiUtils.getPostParams("org", org));
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                ExecuteResponse<Boolean> result = mapper.readValue(content,	new TypeReference<ExecuteResponse<Boolean>>() {});
//                return result;
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }

//    public  ExecuteResponse<Integer> deleteorg() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/org/delete");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("codes", "MM");
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content,	new TypeReference<ExecuteResponse<Integer>>() {});
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }

//    public PageResponse<UIMOrg> orgchange() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/org/change");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("fromId", "6641788");
//            method.addParameter("toId", "6945123");
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<PageResponse<UIMOrg>>(){});
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }

    public  ExecuteResponse<Integer> relations() {

        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        Map<String, String> relations = new HashMap<String, String>();
        relations.put("rainsoft", "MM");

        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/org/relations");
        try {
            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 添加POST BODY
            method.addParameters(OpenApiUtils.getPostParams("relations", relations));
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", method.getParameters()));

            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                return mapper.readValue(content, new TypeReference<ExecuteResponse<Integer>>(){});
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public  ExecuteResponse<List<UIMOrg>> orglist() {
        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/org/list");
        try {
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", null));

            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                return mapper.readValue(content, new TypeReference<ExecuteResponse<List<UIMOrg>>>(){});
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public  PageResponse<UIMOrg> orgfind(String name,String value) {
        List<CommonCondition> conditions = new ArrayList<CommonCondition>();
        CommonCondition c = new CommonCondition();
        c.setName(name);
        c.setDataType(DataType.String);
        c.setCriteriaType(CriteriaType.Equals);
        c.setValue(value);
        conditions.add(c);
        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/org/find");
        try {
            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 添加POST BODY
            method.addParameter("page", "0");
            method.addParameter("rows", "20");
            method.addParameters(OpenApiUtils.getPostParams("conditions", conditions));
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null, "zh_CN", method.getParameters()));

            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                return mapper.readValue(content, new TypeReference<PageResponse<UIMOrg>>(){});
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public  void generateQueryString(){
        PostMethod method = new PostMethod(endPoint + "/oauth20/accessToken");
        //method.addParameter("name", "0007374");
        //method.addParameter("age", "31");
        //method.addParameter("accessToken", "RjhtUmJjZUx6QXBxQnRUV21nTWdvTkZxVHV0UmozT0wwcGJnYnVGN05wYzdUZUNtUmJOZ0xKY203bmp6NTlxOCMjMDAwOTcwNA==");
        method.addParameter("uuid", "ff515b0c-3447-404e-94c8-c01659a423f2");
        System.out.println(OpenApiUtils.getOpenApiParams(appKey        , appSecret, null, null, null, null,
                "zh_CN", method.getParameters()));
    }

//    public  String getAccessToken(){
//        PostMethod method = new PostMethod(endPoint + "/oauth20/accessToken");
//        try{
//            method.addParameter("username", "0007374");
//            method.addParameter("password", "xxxx");
//            method.addParameter("terminalType", "MOBILE");
//            method.addParameter("rememberMe", "true");
///*			method.addParameter("captchaId", "e5f863fe-6033-96af-2d7f-bf3a7d0ad1bf");
//			method.addParameter("captcha","0565");*/
//
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//            System.out.println(method.getPath()+ "/" + method.getQueryString());
////System.out.println(method.getQueryString());
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//            Cookie[] cookies = client.getState().getCookies();
//            for (int i = 0; i < cookies.length; i++) {
//                Cookie cookie = cookies[i];
//                System.err.println(
//                        "Cookie: " + cookie.getName() +
//                                ", Value: " + cookie.getValue() +
//                                ", IsPersistent?: " + cookie.isPersistent() +
//                                ", Expiry Date: " + cookie.getExpiryDate() +
//                                ", Comment: " + cookie.getComment());
//            }
//
//            System.out.println("status:" + status);
//            System.out.println("content:" + content);
//            return content;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }

//    public  ExecuteResponse<OAuth20Profile> profile(String accessToken){
//        PostMethod method = new PostMethod(endPoint + "/oauth20/profile/" + accessToken);
//        try{
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 设置请求参数
//
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", null));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//            System.out.println("content:" + content);
//            if(content==null){
//                System.out.println("null");
//            }
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                ExecuteResponse<OAuth20Profile> profile = mapper.readValue(content,
//                        new TypeReference<ExecuteResponse<OAuth20Profile>>() {
//                        });
//                return profile;
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }

    public  ExecuteResponse<UIMUser> readuser(String userName) {
        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
        manager.getParams().setDefaultMaxConnectionsPerHost(100);
        HttpClient client = new HttpClient(manager);
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/user/" + userName);
        try {
            // 标识是OpenAPI请求
            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
            // 设置请求参数
            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
                    "zh_CN", null));
            // 执行请求
            int status = client.executeMethod(method);
            String content = method.getResponseBodyAsString();

            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
                // 反序列化结果
                ObjectMapperImpl mapper = new ObjectMapperImpl();
                ExecuteResponse<UIMUser> user = mapper.readValue(content,
                        new TypeReference<ExecuteResponse<UIMUser>>() {
                        });
                return user;
            } else {
                throw new Exception("错误的请求");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

//    public  ExecuteResponse<Boolean> existuser(String userName) {
//        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/user/exist/" + userName);
//        try {
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", null));
//            // 执行请求
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//
//    public  ExecuteResponse<Boolean> kickuser(String userName) {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/sessions/kickuser/" + userName);
//        try {
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", null));
//            // 执行请求
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public   ExecuteResponse<Boolean> saveuser() {
//        UIMUser user = new UIMUser();
//        user.setEffectiveDate(new Date());
//        user.setEmail("rain@email.com");
//        user.setEnabled(new Boolean(true));
//        user.setImid("test");
//        user.setLeaderAccount("admin");
//        user.setLocale("zh_CN");
//        user.setMobile("12333444");
//        user.setOfficeTax("1222222");
//        user.setOfficeTel("8278");
//        user.setOrgCode("IT");
//        user.setPassword(OpenApiUtils.md5("1234"));
//        user.setSex("M");
//        user.setTheme("default");
//        user.setTimezone("GMT+0800");
//        user.setUserFrom(appKey);
//        user.setUserName("3419test2");
//        user.setUserNo("3419test2");
//        user.setUserRealName("王**");
//        user.setUserType("SYS");
//
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/save");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.setRequestBody(OpenApiUtils.getPostParams("user", user));
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                ExecuteResponse<Boolean> result = mapper.readValue(content,
//                        new TypeReference<ExecuteResponse<Boolean>>() {
//                        });
//                return result;
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<Integer> deleteuser() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/delete");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("userNames", "User097");
//            method.addParameter("userNames", "User098");
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Integer>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  PageResponse<UIMUser> userchange() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/change");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("fromId", "8295796");
//            method.addParameter("toId", "8662327");
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<PageResponse<UIMUser>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<Integer> changepwds() {
//        Map<String, String> users = new HashMap<String, String>();
//        users.put("162158789", OpenApiUtils.md5("112233"));
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/chgpwds");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameters(OpenApiUtils.getPostParams("users", users));
//            method.addParameter("isNeedChangePassword", "true");
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//            System.out.println("content:" + content);
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Integer>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<Boolean> changemypwd() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/chgmypwd");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("userName", "1602");
//            method.addParameter("oldPassword", OpenApiUtils.md5("admin123ccc"));
//            method.addParameter("newPassword", OpenApiUtils.md5("admin123ddd"));
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<Boolean> canchangemypwd() {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/canchgmypwd");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("userName", "360488750");
//            method.addParameter("oldPassword", OpenApiUtils.md5("Ld232432").toLowerCase());
//            method.addParameter("newPassword", OpenApiUtils.md5("Admin312").toLowerCase());
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  PageResponse<UIMUser> userfind() {
//        List<CommonCondition> conditions = new ArrayList<CommonCondition>();
//        CommonCondition c = new CommonCondition();
//        c.setName("userName");
//        c.setDataType(DataType.String);
//        c.setCriteriaType(CriteriaType.StartWith);
//        c.setValue("User1");
//        conditions.add(c);
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/find");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("page", "0");
//            method.addParameter("rows", "20");
//            method.addParameters(OpenApiUtils.getPostParams("conditions", conditions));
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<PageResponse<UIMUser>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<PasswordPolicy> pwdpolicy() {
//        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/user/pwdpolicy");
//        try {
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", null));
//            // 执行请求
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                ExecuteResponse<PasswordPolicy> passwordPolicy = mapper.readValue(content,
//                        new TypeReference<ExecuteResponse<PasswordPolicy>>() {
//                        });
//                return passwordPolicy;
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<Boolean> verifypwd(String userName, String password) {
//        PostMethod method = new PostMethod(endPoint + "/admin/macula-uim/user/verifypwd");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("userName", userName);
//            method.addParameter("password", OpenApiUtils.md5(password).toLowerCase());
//
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            System.out.println("method.getQueryString():" + method.getQueryString());
//            System.out.println("method.method.getParameters()[0]:" + method.getParameters()[0]);
//            System.out.println("method.method.getParameters()[1]:" + method.getParameters()[1]);
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//            System.out.println(content);
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<Boolean>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<PasswordPolicy> pwdpolicy(String userType) {
//        GetMethod method = new GetMethod(endPoint + "/admin/macula-uim/user/pwdpolicy/" + userType);
//        try {
//            // 标识是OpenAPI请求
//            //method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", null));
//
//            // 执行请求
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                ExecuteResponse<PasswordPolicy> pwdPolicy = mapper.readValue(content,
//                        new TypeReference<ExecuteResponse<PasswordPolicy>>() {
//                        });
//                return pwdPolicy;
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  String getCapthaId(){
//        GetMethod method = new GetMethod(endPoint + "/captchaid");
//        try {
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//            return content;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
//
//    public  ExecuteResponse<String> getShortUrl() {
//        PostMethod method = new PostMethod(endPoint + "/surl/create");
//        try {
//            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//            // 标识是OpenAPI请求
//            method.addRequestHeader(OpenApiUtils.AJAX_REQUEST_HEADER, OpenApiUtils.API_REQUEST_VALUE);
//            // 添加POST BODY
//            method.addParameter("longUrl", "http://172.21.29.53:8080/dubbodemo3-webapp/admin/macula-base/application/list");
//            method.addParameter("toUserAccount", "0009704");
//            method.addParameter("accountType", "USERNAME");
//
//            // 设置请求参数
//            method.setQueryString(OpenApiUtils.getOpenApiParams(appKey, appSecret, null, null, null, null,
//                    "zh_CN", method.getParameters()));
//
//            int status = client.executeMethod(method);
//            String content = method.getResponseBodyAsString();
//
//            if (status == HttpServletResponse.SC_OK || status == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
//                // 反序列化结果
//                ObjectMapperImpl mapper = new ObjectMapperImpl();
//                return mapper.readValue(content, new TypeReference<ExecuteResponse<String>>() {
//                });
//            } else {
//                throw new Exception("错误的请求");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            method.releaseConnection();
//        }
//        return null;
//    }
}
