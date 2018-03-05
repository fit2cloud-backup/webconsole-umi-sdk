/**
 * PageResponse.java 2011-9-6
 */
package model.vo;

import java.util.List;

/**
 * <p>
 * <b>PageResponse</b> is
 * </p>
 *
 * @since 2011-9-6
 * @author zhengping_wang
 * @version $Id: PageResponse.java 4847 2014-02-14 07:10:02Z wzp $
 */
public class PageResponse<T> extends Response {
	/** 本次请求的记录数 */
	private int size;

	/** 当前页码，从零开始 */
	private int number;

	/** 总记录数 */
	private long totalElements;

	/** 总页数 */
	private int totalPages;

	/** 本页的总记录数 */
	private int numberOfElements;

	/** 是否首页 */
	private boolean firstPage;

	/** 是否最后页 */
	private boolean lastPage;

	/** 内容列表 */
	private List<T> content;

    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
}
