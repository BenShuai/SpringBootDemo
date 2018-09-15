package com.it.common.vo.ty.res;

import java.io.Serializable;

public class ResBaseVO  implements  Serializable{
    private static final long serialVersionUID = -8707203013791429605L;
    /**请求编号*/
    private String reqNo;
    /**订单编号*/
    private String orderNo;
    /**交易状态
    * 通用状态
    * 0	适用于短信快捷收款业务，调用短信确认接口，短信验证码验证失败时，订单状态置为0，验证三次失败时，订单状态置为2-交易失败。
    * 1	SUCCESS	交易成功
    * 2	FAIL	交易失败
    * 3	IN_PROCESS	交易处理中，非实时交易或者处于未知状态的交易会存在此状态. 	1-短信扣款业务，在没收到短信确认前都是处理中状态；2-交易正在处理，商户异步发起查询会返回处理中状态。
    * 4	EXCEPTION_SUCCESS	异常成功	当交易提交给银行处理，比如银行网络故障,未返回响应信息，快付通代付接口会返回该状态，表示交易异常
    * 5	EXCEPTION_FAIL	异常失败	当交易提交给银行处理，比如银行网络故障,未返回响应信息，快付通代扣接口会返回该状态，表示交易异常
    * 结算状态
    * 0	UN_PROSESSED 未结算
    * 1	PROSESSED	   已结算
    * */
    private String status;
    /**短信流水号*/
    private String smsSeq;
    /**失败详情*/
    private String failureDetails;
    /**错误码*/
    private String errorCode;
	public String getReqNo() {
		return reqNo;
	}
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSmsSeq() {
		return smsSeq;
	}
	public void setSmsSeq(String smsSeq) {
		this.smsSeq = smsSeq;
	}
	public String getFailureDetails() {
		return failureDetails;
	}
	public void setFailureDetails(String failureDetails) {
		this.failureDetails = failureDetails;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
