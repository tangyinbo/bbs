package com.bestpay.bbs.exception;

public class IllegalParameterStateException extends CommonException{

	public IllegalParameterStateException() {
		super();
	}

	public IllegalParameterStateException(String message, String Code,
			Throwable cause) {
		super(message, Code, cause);
	}

	public IllegalParameterStateException(String message, String Code) {
		super(message, Code);
		// TODO Auto-generated constructor stub
	}

	public IllegalParameterStateException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalParameterStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalParameterStateException(String message) {
		super(message);
	}

	public IllegalParameterStateException(Throwable cause) {
		super(cause);
	}
	
}
