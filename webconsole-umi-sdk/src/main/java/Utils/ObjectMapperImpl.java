/**
 * ObjectMapperImpl.java 2015年5月18日
 */
package Utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * <p>
 * <b>ObjectMapperImpl</b> 基于jackson的设置默认的转换属性
 * </p>
 *
 * @since 2015年5月18日
 * @author Rain
 * @version $Id$
 */
public class ObjectMapperImpl extends com.fasterxml.jackson.databind.ObjectMapper {

	private static final long serialVersionUID = 1L;

	/**
	 * 设置一些默认配置
	 */
	public ObjectMapperImpl() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		this.setDateFormat(df);
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		this.registerModule(new JaxbAnnotationModule());
		this.registerModule(new JodaModule());
	}
}
