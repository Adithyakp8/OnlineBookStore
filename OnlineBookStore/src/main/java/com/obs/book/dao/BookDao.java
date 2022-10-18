package com.obs.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.obs.book.model.Book;

public interface BookDao extends JpaRepository<Book,String>{

	@Query("SELECT b FROM Book b WHERE b.bookGenre LIKE CONCAT('%',:bgenre,'%')")
	List<Book> findByBookGenre(String bgenre);
	
	@Query("SELECT b FROM Book b WHERE b.bookAuthor LIKE CONCAT('%',:bauth,'%')")
	List<Book> findByBookAuthor(String bauth);
	
	@Query("SELECT b FROM Book b WHERE b.bookName LIKE CONCAT('%',:bname,'%')")
	List<Book> findByBookName(String bname);

}
