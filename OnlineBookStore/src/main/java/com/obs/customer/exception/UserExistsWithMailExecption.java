package com.obs.customer.exception;

public class UserExistsWithMailExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message = "User already exists with this same email!";
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
