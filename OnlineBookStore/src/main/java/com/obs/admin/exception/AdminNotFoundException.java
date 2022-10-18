package com.obs.admin.exception;

public class AdminNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message="Invalid Credentials! Try Again!";

	public AdminNotFoundException() {

	}

	public AdminNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

