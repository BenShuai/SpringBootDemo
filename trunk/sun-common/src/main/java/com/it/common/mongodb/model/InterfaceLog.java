package com.it.common.mongodb.model;

 

public class InterfaceLog implements  java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
    private String bizCode;       //接口编号
    private String operation;     //操作：query、delete(应该没有)、insert、update、multiple(多个操作一个事务)、upload(文件上传)、download(文件下载)
    private long duration;        //接口运行时长
    private String userid;        //操作用户ID
    private int isAsynchronous;   //是否异步处理  0非异步
    private String business;      //投资、登录、注册、查询、转让、充值等
    private String doc;
    private int state = 1 ;       //是否异常 0异常
    private String mgs ="success";//异常信息
    private long startTime;       //开始时间
    private long endTime;         //结束时间
    private String runTime ;      //yyyy-MM-dd HH:mm:ss
    
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
	 
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	 
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	 
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public int getIsAsynchronous() {
		return isAsynchronous;
	}
	public void setIsAsynchronous(int isAsynchronous) {
		this.isAsynchronous = isAsynchronous;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMgs() {
		return mgs;
	}
	public void setMgs(String mgs) {
		this.mgs = mgs;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}

   
}
