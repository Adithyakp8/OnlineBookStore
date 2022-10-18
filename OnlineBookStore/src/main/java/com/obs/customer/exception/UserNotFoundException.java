package com.obs.customer.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message = "Invalid Credentials! Try Again!";

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
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
