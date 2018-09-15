package com.it.common.base.vo.response;

import java.io.Serializable;
import java.util.List;

public class PageResponsVO <T>   implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;

	protected List<T> list;

	protected int pageSize;

	protected int pageNumber;

	protected int totalCount = 0;
	
	public PageResponsVO(int pageNumber,int pageSize,int totalCount,List<T> list) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.totalCount = totalCount;
		this.list=list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
