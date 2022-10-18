package com.obs.book.exception;

public class NoBookFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String msg = "No Books Found!";
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public NoBookFoundException(String path) {
		super();
		this.path = path;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
