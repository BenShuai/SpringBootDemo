
package com.example.demo.entity;
import java.io.Serializable;

/**
 * 金账户发送请求表
 * 
 * @author sunshuai
 * @email sunshuai@szpyph.com
 * @date 2018-05-25
 */
public class JzhApiRequests implements Serializable {
	private static final long serialVersionUID = 1L;

	/**/
	private Integer id;
	/**/
	private String seqNo;
	/*接口服务名称*/
	private String requestUri;
	/*发送参数*/
	private String requestContent;
	/*响应结果*/
	private String responseContent;
	/*返回状态码*/
	private String retCode;
	/**/
	private long createdAt;
	/**/
	private long updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
}
