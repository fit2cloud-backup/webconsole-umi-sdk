/**
 * Response.java 2011-9-6
 */
package model.vo;

import java.util.List;

/**
 * <p>
 * <b>Response</b> 返回数据结构的基类
 * </p>
 *
 * @since 2011-9-6
 * @author zhengping_wang
 * @version $Id: Response.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class Response {
	/** 是否成功标识 */
	private boolean success;

	/** 系统级错误代码 */
	private String errorCode;
	/** 系统级错误信息 */
	private String errorMessage;

	/** 业务级错误代码 */
	private String exceptionCode;
	/** 业务级错误信息 */
	private String exceptionMessage;

	/** 异常详细信息 */
	private String exceptionStack;

	/** 服务端重定向信息 */
	private String redirection;

	/** 校验结果信息 */
	private List<FieldError> validateErrors;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionStack() {
		return exceptionStack;
	}

	public void setExceptionStack(String exceptionStack) {
		this.exceptionStack = exceptionStack;
	}

	public String getRedirection() {
		return redirection;
	}

	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}

	public List<FieldError> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<FieldError> validateErrors) {
		this.validateErrors = validateErrors;
	}
}
