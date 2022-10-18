package com.obs.admin.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.admin.dao.AdminDao;
import com.obs.admin.exception.AdminNotFoundException;
import com.obs.admin.exception.InvalidInputException;
import com.obs.admin.model.Admin;
import com.obs.book.dao.BookDao;
import com.obs.book.model.Book;
import com.obs.coupon.dao.CouponDao;
import com.obs.coupon.model.Coupon;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;

	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private CouponDao coupondao;

	public Admin login(Admin adm) {

		Admin admin = admindao.findByAdminEmailAndAdminPassword(adm.getAdminEmail(),adm.getAdminPassword());
		if (admin == null) {
			throw new AdminNotFoundException();
		}
		return admin;

	}

	public List<Book> getAllBooks() {
		return bookdao.findAll();
	}

	public Book getBook(Book bk) {
		Book book = bookdao.findById(bk.getBookId()).get();
		return book;
	}

	public void updateBook(Book book) {
		bookdao.save(book);
	}

	public void deleteBook(Book book) {
		bookdao.delete(book);
	}

	public void addBook(Book book) {
		
		bookdao.save(book);
	}

	public void updateAdmin(Admin admin) {
		admindao.save(admin);
	}
	
	public List<Book> search(String str) {
		List<Book> list1 = bookdao.findByBookName(str);
		List<Book> list2 = bookdao.findByBookAuthor(str);
		List<Book> list3 = bookdao.findByBookGenre(str);
		list1.addAll(list2);
		list1.addAll(list3);
		return list1;
	}
	
	public List<Coupon> getCoupons(){
		return coupondao.findAll();
		
	}
	
	public void deleteCoupon(Coupon coupon) {
		coupondao.deleteById(coupon.getCouponId());
	}
	
	public void addCoupon(Coupon coupon) {
		coupondao.save(coupon);
	}


}
