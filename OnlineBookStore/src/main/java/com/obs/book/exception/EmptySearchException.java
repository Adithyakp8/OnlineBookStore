package com.obs.book.exception;

public class EmptySearchException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message = "Search input is empty!";
	private String path;

	public EmptySearchException(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
