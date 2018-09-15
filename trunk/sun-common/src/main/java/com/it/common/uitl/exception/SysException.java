package com.it.common.uitl.exception;

import java.text.MessageFormat;
 
public class SysException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorMsg;
    
    public SysException(String errorCode, String errorMsg) {
        super(errorCode + ":" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public SysException(ExCode exCode) {
        this(exCode.getErrorCode(), exCode.getErrorMsg());
    }
    
    public SysException(String errorCode, String errorMsg, Object ... args){
        super(errorCode + ":" + MessageFormat.format(errorMsg, args));
        this.errorCode = errorCode;
        this.errorMsg = MessageFormat.format(errorMsg, args);
    }
    
    public SysException(ExCode exCode, Object ... args){
        this(exCode.getErrorCode(), exCode.getErrorMsg(), args);
    }
    
    public SysException(String errorCode, String errorMsg, Throwable paramThrowable) {
        super(errorCode + ":" + errorMsg, paramThrowable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public SysException(ExCode exCode, Throwable paramThrowable) {
        this(exCode.getErrorCode(), exCode.getErrorMsg(), paramThrowable);
    }
    
    public SysException(String errorCode, String errorMsg, Throwable paramThrowable, Object ... args){
        super(errorCode + ":" + MessageFormat.format(errorMsg, args), paramThrowable);
        this.errorCode = errorCode;
        this.errorMsg = MessageFormat.format(errorMsg, args);
    }
    
    public SysException(ExCode exCode, Throwable paramThrowable, Object ... args){
        this(exCode.getErrorCode(), exCode.getErrorMsg(), paramThrowable, args);
    }

    public SysException(String errorCode, Throwable paramThrowable) {
        super(errorCode, paramThrowable);
        this.errorCode = errorCode;
        Throwable rootCause = ExceptionUtil.getRootCause(paramThrowable);
        this.errorMsg = rootCause != null ? rootCause.getMessage() : "SysException";
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}