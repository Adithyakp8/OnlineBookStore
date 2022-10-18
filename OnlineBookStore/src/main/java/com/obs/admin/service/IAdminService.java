package com.obs.admin.service;

import java.util.List;

import com.obs.admin.model.Admin;
import com.obs.book.model.Book;

public interface IAdminService {
	
	public Admin login(Admin adm);
	
	public List<Book> getAllBooks();
	
	public Book getBook(Book bk);
	
	public void updateBook(Book book);
	
	public void deleteBook(Book book);
	
	public void addBook(Book book);
	
	public void updateAdmin(Admin admin);
	
	public List<Book> search(String str);
	

}
