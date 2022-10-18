package com.obs.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.customer.model.Purchase;

public interface PurchaseDao extends JpaRepository<Purchase, String> {

	List<Purchase> findAllByCustId(String custId);

	List<Purchase> findAllByBookId(String bookId);

	List<Purchase> findAllByCustIdAndBookId(String custId, String bookId);

}
