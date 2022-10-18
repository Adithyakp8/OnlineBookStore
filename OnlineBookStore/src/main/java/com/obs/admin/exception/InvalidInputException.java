package com.obs.admin.exception;

import com.obs.book.model.Book;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message="Invalid input! Check again!";
	private String path;
	private Book book;
	

	public InvalidInputException(String path, Book book) {
		super();
		this.path = path;
		this.book = book;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public InvalidInputException(String path) {
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
