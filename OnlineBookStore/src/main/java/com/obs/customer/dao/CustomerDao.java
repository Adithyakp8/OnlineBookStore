package com.obs.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.customer.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

	Customer findByCustEmail(String custEmail);

	Customer findByCustEmailAndCustPassword(String custEmail, String custPassword);
	

}
