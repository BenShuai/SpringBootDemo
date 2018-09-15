package com.it.common.base.vo.response;

import java.io.Serializable;

public class ObejectResponsVO<T>  implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;
	
	private Object object ;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
