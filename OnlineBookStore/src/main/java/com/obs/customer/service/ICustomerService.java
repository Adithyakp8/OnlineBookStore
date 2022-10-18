package com.obs.customer.service;

import java.util.List;

import com.obs.book.model.Book;
import com.obs.customer.model.Cart;
import com.obs.customer.model.Customer;
import com.obs.customer.model.Purchase;

public interface ICustomerService {
	
	public Customer signUp(Customer cust);
	
	public Customer login(Customer customer);
	
	public List<Book> getAllBooks();
	
	public Cart addToCart(Customer cust, Book book);
	
	public List<Cart> getCartItems(Customer cust);
	
	public void empty(String cartId);
	
	public void emptyAll(String custId);
	
	public List<Purchase> getPurchaseItems(Customer cust);
	
	public void updatecust(Customer customer);
	
	public void getPurchase(List<Cart> carts,Customer customer);
	
	public Customer getCustomer(String custId);
	
	public List<Book> recomandBooks(Customer cust);

}
