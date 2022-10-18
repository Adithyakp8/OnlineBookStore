package com.obs.book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obs.admin.service.AdminService;
import com.obs.book.exception.EmptySearchException;
import com.obs.book.exception.NoBookFoundException;
import com.obs.book.model.Book;
import com.obs.book.service.BookService;
import com.obs.customer.model.Customer;

@Controller
public class BookController {
	@Autowired
	private BookService bs;
	
	@RequestMapping("search")
	public String getSearch(@RequestParam("term") String term,ModelMap m) {
		
		if(term.isEmpty())
			throw new EmptySearchException("customer");
		
		List<Book> flist = bs.search(term);
		if(flist.isEmpty())
			throw new NoBookFoundException("customer");
		m.addAttribute("size",0);
		m.addAttribute("bookList",flist);
		return "customer/home";
		
	}
}
