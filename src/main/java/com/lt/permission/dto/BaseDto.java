package com.lt.permission.dto;

import java.io.Serializable;

/**
 * 请求参数基类
 * 
 * @author lantian
 * 
 */
public class BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 当前页数,默认为第�?�� * */
	private Integer currentPage = 1;
	/** 每页显示的记录数 默认�?20条记�?* */
	private Integer pageSize = 20;

	private boolean isCheck = true;

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
