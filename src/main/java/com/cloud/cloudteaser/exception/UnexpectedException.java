package com.cloud.cloudteaser.exception;

public class UnexpectedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UnexpectedException(String message) {
		super(message);
	}
	
	public UnexpectedException(String message, Throwable cause) {
		super(message, cause);
	}
}
