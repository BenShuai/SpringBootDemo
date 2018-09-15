package com.it.common.base.vo.request;

import java.io.Serializable;

public class BaseHdRequestVO implements Serializable{
	private static final long serialVersionUID = -2131640102040244551L;
	 
	/** 
	 *接口流水号  必填
	 **/
	private String reqSsn;
	 
	/** 
	 *请求时间  YYYYMMDDHHSS 非必填
	 * */
	private String reqDate;
	/** 
	 *版本号  必填 1.0
	 * */
	private String version;
	/** 
	 * 用户终端请求签名（流水+版本号+请求时间） SHA1 非必填
	 * */
	private String sign;
	/**
	 * 接口业务代码 
	 */
	private String bizCode;
	
	/** 
	 * 终端类型  必填 PCB(PC浏览器)、PCC(PC客户端)、WAP(手机浏览器)、AN(安卓)、IOS
	 * */
	private String termType;
	
	/**
	 * 用户编号
	 */
	private String userId;

	public String getReqSsn() {
		return reqSsn;
	}

	public void setReqSsn(String reqSsn) {
		this.reqSsn = reqSsn;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
