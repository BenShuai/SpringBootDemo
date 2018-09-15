package com.it.common.uitl.exception;
 

public enum APPExCode implements ExCode{
	
	SUCCESS("000000", "成功"),
	
	// SYS 异常
	SYS_EX_NO_LOGIN(SYS_EX_PREFIX + "S00001", "您尚未登录或登录时间过长,请重新登录!"),
	SYS_EX_NO_AUTH(SYS_EX_PREFIX + "S00002", "您没有足够的权限执行该操作!"),
	SYS_UNKNOWN_ERROR(SYS_EX_PREFIX + "500", "系统异常"),
	USER_TISHI_ERROR(BIZ_EX_PREFIX + "100", ""),
	USER_CODE_ERROR(BIZ_EX_PREFIX + "S00003","验证码不正确"),
	USER_EXIST_ERROR(BIZ_EX_PREFIX + "S00004","此号码已被注册"),
	USER_NOT_EXIST_ERROR(BIZ_EX_PREFIX + "S00005","用户不存在"),
	SYS_SEQ_PROC_NOT_FOUND(SYS_EX_PREFIX + "100", "数据不符合系统验证规则");

    public String errorCode;
    public String errorMsg;
    
    private APPExCode(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}
}