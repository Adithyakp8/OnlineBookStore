package com.obs.helper.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.obs.admin.exception.AdminNotFoundException;
import com.obs.admin.exception.InvalidInputException;
import com.obs.admin.model.Admin;
import com.obs.admin.service.AdminService;
import com.obs.book.exception.EmptySearchException;
import com.obs.book.exception.NoBookFoundException;
import com.obs.customer.exception.EmptyCartException;
import com.obs.customer.exception.UserExistsWithMailExecption;
import com.obs.customer.exception.UserNotFoundException;
import com.obs.customer.model.Cart;
import com.obs.customer.model.Customer;
import com.obs.customer.service.CustomerService;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private CustomerService custservice;
	
	@Autowired
	private AdminService admservice;
	
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	
	@ExceptionHandler(AdminNotFoundException.class)
	public String adminNotFound(Model model, HttpServletRequest req, AdminNotFoundException e) {
		String msg = e.getMessage();
		req.setAttribute("msg", msg);
		model.addAttribute("admin", new Admin());
		log.error("Admin Not Found, Invalid Credentials");
		return "admin/adminLoginPage";
	}

	@ExceptionHandler(InvalidInputException.class)
	public String invalidInput(Model model, HttpServletRequest req, InvalidInputException e) {
		String msg = e.getMessage();
		log.error("Invalid Input");
		if(e.getPath().equals("addBook")) {
			req.setAttribute("msg", msg);
			return "admin/addBook";
		}
		req.setAttribute("msg", msg);
		model.addAttribute("book",admservice.getBook(e.getBook()));
		return "admin/editBook";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFound(Model model, HttpServletRequest req, UserNotFoundException e) {
		String msg = e.getMessage();
		req.setAttribute("msg", msg);
		model.addAttribute("cust", new Customer());
		log.error("User Not Found,Invalid Credentials");
		return "customer/custlogin";
	}

	@ExceptionHandler(UserExistsWithMailExecption.class)
	public String userExists(Model model, HttpServletRequest req, UserExistsWithMailExecption e) {
		String msg = e.getMessage();
		req.setAttribute("msg", msg);
		model.addAttribute("cust", new Customer());
		log.error("User already exists with the respective Mail");
		return "customer/custsignup";
	}
	
	@ExceptionHandler(EmptySearchException.class)
	public String emptySearchException(Model model, EmptySearchException e,HttpSession session) {
		if(e.getPath().equals("customer")) {
			model.addAttribute("recomends",custservice.recomandBooks((Customer) session.getAttribute("cust")));
			model.addAttribute("size",custservice.recomandBooks((Customer) session.getAttribute("cust")).size());
			model.addAttribute("bookList",custservice.getAllBooks());
			return "customer/home";
		}
		model.addAttribute("bookList",admservice.getAllBooks());
		return "admin/adminHome";
	}
	
	@ExceptionHandler(NoBookFoundException.class)
	public String noBookFound(Model model,HttpServletRequest req,  NoBookFoundException e) {
		String msg = e.getMsg();
		log.error("No book Found");
		if(e.getPath().equals("customer")) {
			req.setAttribute("msg", msg);
			model.addAttribute("size",0);
			return "customer/home";
		}
		req.setAttribute("msg", msg);
		return "admin/adminHome";
	}
	
	@ExceptionHandler(EmptyCartException.class)
	public String emptycart(HttpSession session, Model m, HttpServletRequest req) {
		req.setAttribute("msg", "Add items to cart!");
		Customer cust = (Customer) session.getAttribute("cust");
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		log.error("Your Cart is Empty");
		return "customer/cart";
	}
}
