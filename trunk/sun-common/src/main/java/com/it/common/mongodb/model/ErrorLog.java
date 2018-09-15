package com.it.common.mongodb.model;

public class ErrorLog implements  java.io.Serializable{
	private String id;
    private String bizCode;       //接口编号
    private String operation;     //操作：query、delete(应该没有)、insert、update、multiple(多个操作一个事务)、upload(文件上传)、download(文件下载)
    private String userid;        //操作用户ID
    private String isAsynchronous;//是否异步处理
    private String business;      //投资、登录、注册、查询、转让、充值等
    private String errorMessage;  //e.getMessage()   
    private String errorInfo;     //e.toString()
    private String doc;           //备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIsAsynchronous() {
		return isAsynchronous;
	}
	public void setIsAsynchronous(String isAsynchronous) {
		this.isAsynchronous = isAsynchronous;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
    
    
}
