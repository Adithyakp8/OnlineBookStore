package com.obs.customer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.obs.book.model.Book;
import com.obs.coupon.model.Coupon;
import com.obs.customer.exception.EmptyCartException;
import com.obs.customer.model.Cart;
import com.obs.customer.model.Customer;
import com.obs.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	
	Logger log = LoggerFactory.getLogger(CustomerController.class);

	
	@Autowired
	private CustomerService custservice;
	
	@RequestMapping("signin")
	public String getSignin(Model model) {
		model.addAttribute("cust", new Customer());
		return "customer/custsignup";
		
	}
	
	@RequestMapping("signup")
	public String getSignUp(@Valid @ModelAttribute("cust") Customer cust, BindingResult br) {
		if(br.hasErrors()) {
			log.error("Wrong Credentials Entered");
			return "customer/custsignup";
		}
		custservice.signUp(cust);
		log.info("SignUp Successful");
		return "redirect:log";
	}
	
	@RequestMapping("log")
	public String getLog(Model model) {
		model.addAttribute("cust", new Customer());
		return "customer/custlogin";
	}
	
	@RequestMapping("login")
	public String getLogin(@Valid @ModelAttribute("cust") Customer cust, BindingResult br,HttpSession session, Model m) {
		if(br.hasErrors()) {
			log.error("Wrong Credentials Entered");
			return "customer/custlogin";
			
		}
		Customer Customertemp = custservice.login(cust);
		session.setAttribute("cust", Customertemp);
	    m.addAttribute("bookList",custservice.getAllBooks());
	    m.addAttribute("recomends",custservice.recomandBooks(Customertemp));
	    m.addAttribute("size",custservice.recomandBooks(Customertemp).size());
	    log.info("Successfully Logged in");
		return "customer/home";
	}
	
	@RequestMapping("logout")
	public String logout(@ModelAttribute("cust") Customer cust, HttpSession session) {
		session.invalidate();
		log.info("Logout Successful");
		return "customer/custlogin";
	}
	
	@RequestMapping("addtocart")
	public String getCart(HttpSession session,Book book,ModelMap m) {
		Customer cust = (Customer) session.getAttribute("cust");
		Cart cart = custservice.addToCart(cust, book);
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		if(cart!=null) {
			log.info("Successfully Added to Cart");
			return "customer/cart";
		}
		log.warn("Book Already Exists in cart or my books");
		return "redirect:backToHome";
	}
	
	@RequestMapping("backToHome")
	public String backHome(HttpSession session, ModelMap m) {
		Customer cust = (Customer) session.getAttribute("cust");
		  m.addAttribute("bookList",custservice.getAllBooks());
		  m.addAttribute("recomends",custservice.recomandBooks(cust));
		  m.addAttribute("size",custservice.recomandBooks(cust).size());
		return "customer/home";
	}
	
	@RequestMapping("viewcart")
	public String viewCart(ModelMap m,HttpSession session) {
		Customer cust = (Customer) session.getAttribute("cust");
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		return "customer/cart";
		
	}
	
	@RequestMapping("emptycart")
	public String emptyCart(@RequestParam("cartId") String cartId,HttpSession session, ModelMap m) {
		Customer cust = (Customer) session.getAttribute("cust");
		custservice.empty(cartId);
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		log.info("Removed from cart");
		return "customer/cart";
	}
	
	@RequestMapping("emptyall")
	public String emptyAll(HttpSession session,ModelMap m) {
		Customer cust = (Customer) session.getAttribute("cust");
		custservice.emptyAll(cust.getCustId());
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		log.info("Removed all the items from the cart");
		return "customer/cart";
		
	}
		
	@RequestMapping("purchase")
	public String getPurchase(HttpSession s) {
		Customer customer = (Customer)s.getAttribute("cust");
		if(custservice.getCartItems(customer).isEmpty())
			throw new EmptyCartException();
		return "customer/purchase";
		
	}
	@RequestMapping("pay")
	public String getPay(HttpSession session,ModelMap m){
		Customer customer = (Customer) session.getAttribute("cust");
		List<Cart> carts = custservice.getCartItems(customer);
		custservice.getPurchase(carts, customer);
		custservice.emptyAll(customer.getCustId());
		m.addAttribute("carts",custservice.getCartItems(customer));
		return "customer/confirmation";
	}
	
	@RequestMapping("showBook")
	public String showBook(Book book,ModelMap m) {
		m.addAttribute("book", custservice.getBook(book));
		return "customer/bookDetails";
		
	}
	
	@RequestMapping("orders")
	public String getOrders(HttpSession session, ModelMap m) {
		Customer customer = (Customer) session.getAttribute("cust");
		m.addAttribute("purchases",custservice.getPurchaseItems(customer));
		return "customer/custOrders";
		
	}
	
	@RequestMapping("updatedetails")
	public String update(ModelMap m, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("cust");
		m.addAttribute("cust", customer);
		return "customer/updateCust";
	}

	@RequestMapping("updatecust")
	public String getUpdate(@Valid @ModelAttribute("cust") Customer cust, BindingResult br, HttpSession session,
			ModelMap m) {
		if (br.hasErrors()) {
			log.warn("Invalid Details, Check once more");
			return "customer/updateCust";
		}
		Customer customer = (Customer) session.getAttribute("cust");
		customer.setCustName(cust.getCustName());
		customer.setCustMobile(cust.getCustMobile());
		customer.setCustPassword(cust.getCustPassword());
		custservice.updatecust(customer);
		m.addAttribute("bookList", custservice.getAllBooks());
		m.addAttribute("recomends",custservice.recomandBooks((Customer) session.getAttribute("cust")));
		m.addAttribute("size",custservice.recomandBooks((Customer) session.getAttribute("cust")).size());
		return "customer/home";

	}
	@RequestMapping("customerViewBook")
	public String customerViewBook(Book book) {
		return "customer/bookPreView";
	}
	
	@RequestMapping("about")
	public String getAbout() {
		return "customer/about";
	}
	
	@RequestMapping("contact")
	public String getContact() {
		return "customer/contact";
	}
	
	@RequestMapping("applyCoupon")
	public String getCouon(HttpSession session,Model m,Coupon coupon) {
		Customer cust = (Customer) session.getAttribute("cust");
		List<Cart> carts = custservice.getCartItems(cust); 
		m.addAttribute("carts",carts);
		m.addAttribute("total",custservice.getTotalPrice(carts));
		m.addAttribute("coupon",custservice.getCouponValue(coupon));
		return "customer/cart";
		
	}
	
	

}