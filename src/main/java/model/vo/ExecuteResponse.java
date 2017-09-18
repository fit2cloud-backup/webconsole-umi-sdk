/**
 * ExecuteResponse.java 2011-9-6
 */
package model.vo;


/**
 * <p>
 * <b>ExecuteResponse</b> 单记录数据结构
 * </p>
 *
 * @since 2011-9-6
 * @author zhengping_wang
 * @version $Id: ExecuteResponse.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class ExecuteResponse<T> extends Response {
	/** 结果信息 */
	private T returnObject;
	
	public void setReturnObject(T result) {
		this.returnObject = result;
	}

	/**
	 * @return the result
	 */
	public T getReturnObject() {
		return returnObject;
	}
}
