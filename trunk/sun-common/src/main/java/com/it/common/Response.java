package com.it.common;

/**
 * 前端返回数据类
 *
 */
public class Response {

	private int code;
	private String message;
	private Object body;

	public static Response ok() {
		Response response = new Response();
		response.setCode(ErrorCode.SUCCESS.getStatus());
		response.setMessage("成功");
		return response;
	}

	public static Response ok(String message) {
		Response response = new Response();
		response.setCode(ErrorCode.SUCCESS.getStatus());
		response.setMessage(message);
		return response;
	}

	public static Response error(int code, String message) {
		Response response = new Response();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
