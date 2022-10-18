package com.obs.book.service;

import java.util.List;

import com.obs.book.model.Book;

public interface IBookService {
	
	public List<Book> search(String str);

}
