package com.ordersystems.exception;

public class NegocioException extends Exception {

	public NegocioException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NegocioException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NegocioException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NegocioException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
