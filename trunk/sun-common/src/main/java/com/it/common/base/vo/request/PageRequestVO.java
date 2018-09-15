package com.it.common.base.vo.request;

public class PageRequestVO extends PageBaseRequestVO{
	public SearchVO searchvo;
	public OrderVO ordervo;
	public SearchVO getSearchvo() {
		return searchvo;
	}
	public void setSearchvo(SearchVO searchvo) {
		this.searchvo = searchvo;
	}
	public OrderVO getOrdervo() {
		return ordervo;
	}
	public void setOrdervo(OrderVO ordervo) {
		this.ordervo = ordervo;
	}
    
    
}
