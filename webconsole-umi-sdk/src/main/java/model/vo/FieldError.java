/**
 * FieldError.java 2011-9-6
 */
package model.vo;

/**
 * <p>
 * <b>FieldError</b> 字段错误数据结构
 * </p>
 *
 * @since 2011-9-6
 * @author zhengping_wang
 * @version $Id: FieldError.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class FieldError {
	// 元素名，与页面元素名一致  
	private String element;
	
	// 错误信息  
	private String message;
	
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
