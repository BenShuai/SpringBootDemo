package com.it.common.base.vo.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PageBaseRequestVO  implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;
	public PageVO pagevo;
	public PageVO getPagevo() {
		return pagevo;
	}
	public void setPagevo(PageVO pagevo) {
		this.pagevo = pagevo;
	}
	
}
