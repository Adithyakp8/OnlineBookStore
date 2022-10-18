package com.obs.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.customer.model.Cart;

public interface CartDao extends JpaRepository<Cart, String> {

	List<Cart> findAllByCustId(String custId);

	void deleteAllByCustId(String custId);

	List<Cart> findAllByBookId(String bookId);

	List<Cart> findAllByCustIdAndBookId(String custId, String bookId);
	
	

	
	

}