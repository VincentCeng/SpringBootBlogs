package com.saas.common.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -6879298763723247455L;
	
	private int code = 0;

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(int code,String message) {
		super(message);
		this.code = code;
	}
	
	public ServiceException(int code,String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public Throwable fillInStackTrace() {
		return this;
	}

	public int getCode() {
		return code;
	}

}
