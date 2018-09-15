package com.it.common.base.vo.response;

import java.io.Serializable;
import java.util.List;

public class ListResponsVO<T>   implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;
	private List<T> list;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	 
}
