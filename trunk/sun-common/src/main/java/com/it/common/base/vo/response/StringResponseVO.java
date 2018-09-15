package com.it.common.base.vo.response;

import java.io.Serializable;

public class StringResponseVO<T>implements Serializable{
   private static final long serialVersionUID = 2354881465436907718L;
   private String str;

	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
 
}
