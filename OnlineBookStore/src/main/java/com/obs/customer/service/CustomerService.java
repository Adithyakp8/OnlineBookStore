package com.obs.customer.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.book.dao.BookDao;
import com.obs.book.model.Book;
import com.obs.coupon.dao.CouponDao;
import com.obs.coupon.model.Coupon;
import com.obs.customer.dao.CartDao;
import com.obs.customer.dao.CustomerDao;
import com.obs.customer.dao.PurchaseDao;
import com.obs.customer.exception.UserExistsWithMailExecption;
import com.obs.customer.exception.UserNotFoundException;
import com.obs.customer.model.Cart;
import com.obs.customer.model.Customer;
import com.obs.customer.model.Purchase;

@Service
@Transactional
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerDao custdao;

	@Autowired
	private CartDao cartdao;

	@Autowired
	private PurchaseDao purchasedao;

	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private CouponDao coupondao;

	public Customer signUp(Customer cust) {
		if(custdao.findByCustEmail(cust.getCustEmail())!=null) {
			throw new UserExistsWithMailExecption();
		}
		return custdao.save(cust);

	}

	public Customer login(Customer customer) {
		Customer cust = custdao.findByCustEmailAndCustPassword(customer.getCustEmail(),customer.getCustPassword());
		if (cust == null) {
			throw new UserNotFoundException();
		}
		return cust;
}

	public List<Book> getAllBooks() {
		return bookdao.findAll();
	}

	public Cart addToCart(Customer cust, Book book) {
		Cart cart = new Cart();
		book = bookdao.getById(book.getBookId());
		List<Cart> cartlist=cartdao.findAllByCustIdAndBookId(cust.getCustId(),book.getBookId());
		List<Purchase> purchaselist = purchasedao.findAllByCustIdAndBookId(cust.getCustId(),book.getBookId());
			if(cartlist.size()==0&&purchaselist.size()==0) {
			cart.setBookId(book.getBookId());
			cart.setCustId(cust.getCustId());
			cart.setBookPrice(book.getBookPrice());
			cart.setBookName(book.getBookName());
			cart.setCustomer(cust);
			cartdao.save(cart);
			return cart; 
		}
		return null;
		
		

	}

	public List<Cart> getCartItems(Customer cust) {
		List<Cart> carts = cartdao.findAllByCustId(cust.getCustId());
		return carts;

	}
	

	public void empty(String cartId) {
		cartdao.deleteById(cartId);
	}

	public void emptyAll(String custId) {
		cartdao.deleteAllByCustId(custId);
	}

	public List<Purchase> getPurchaseItems(Customer cust) {
		List<Purchase> purchase = purchasedao.findAllByCustId(cust.getCustId());
		return purchase;

	}

	public void updatecust(Customer customer) {
		custdao.save(customer);
	}
	
	public void getPurchase(List<Cart> carts,Customer customer) {
		for(Cart cart:carts) {
			Purchase pur = new Purchase();
			pur.setBookId(cart.getBookId());
			pur.setBookName(cart.getBookName());
			pur.setCustId(cart.getCustId());
			pur.setCustomer(customer);
			purchasedao.save(pur);
		}
		
	}
	
	public Customer getCustomer(String custId) {
		return custdao.findById(custId).get();
	}
	
	public List<Book> recomandBooks(Customer cust){
		List<String> bookIds = new ArrayList<String>();
		Set<String> genres = new HashSet<String>();
		List<Book> books = new ArrayList<Book>();
		for(Purchase purchase:getPurchaseItems(cust)) {
			bookIds.add(purchase.getBookId());
		}
		
		for(String bookId:bookIds) {
			genres.add(bookdao.findById(bookId).get().getBookGenre());
		}
		
		for(String genre:genres) {
			books.addAll(bookdao.findByBookGenre(genre));
		}
		
		for(String bookId:bookIds) {
			books.remove(bookdao.findById(bookId).get());
		}
		return books;
		
	}
	
	
	public Double getTotalPrice(List<Cart> carts) {
		Double total = 0.0;
		for(Cart cart:carts) {
			total+=cart.getBookPrice().doubleValue();
		}
		return total;
		
	}
	
	public double getCouponValue(Coupon coupon) {
		if(coupondao.findByCouponName(coupon.getCouponName())!=null) {
			return coupondao.findByCouponName(coupon.getCouponName()).getCouponPrice();
		}
		return 0;
		
	}
	public Book getBook(Book book) {
		return bookdao.findById(book.getBookId()).get();
	}
}