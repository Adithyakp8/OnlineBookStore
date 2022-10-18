package com.obs.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.book.dao.BookDao;
import com.obs.book.model.Book;

@Service
public class BookService implements IBookService{

	@Autowired
	private BookDao bookdao; 
	
	public List<Book> search(String str) {
		List<Book> list1 = bookdao.findByBookName(str);
		List<Book> list2 = bookdao.findByBookAuthor(str);
		List<Book> list3 = bookdao.findByBookGenre(str);
		list1.addAll(list2);
		list1.addAll(list3);
		return list1;
	}
}
