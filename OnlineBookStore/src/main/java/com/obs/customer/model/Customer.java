package com.obs.customer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Parameter;

import com.obs.helper.sequenceGeneration.StringSequence;



@Entity
public class Customer {
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "cust_seq")
    @GenericGenerator(name="cust_seq",
            strategy = "com.obs.helper.sequenceGeneration.StringSequence",
            parameters = {
                    @Parameter(name=StringSequence.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringSequence.VALUE_PREFIX_PARAMETER,value="Cust_"),
                    @Parameter(name=StringSequence.NUMBER_FORMAT_PARAMETER,value="%04d")
            }
            )
	private String custId;
	
	@Column(nullable = false)
	@Size(min = 4, message = "Name must be minimum 4 characters long")
	private String custName;
	
	@Column(nullable = false)
	@Size(min = 10,max=10, message = "Mobile Number should be 10 digits")
	private String custMobile;
	
	@Column(nullable = false)
	@Email
	private String custEmail;
	
	@Column(nullable = false)
	@Size(min = 4, message = "Password must be minimum 4 characters long")
	private String custPassword;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	private List<Cart> cart = new ArrayList<Cart>();
	

	@OneToMany(mappedBy = "customer")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Purchase> purchase =  new ArrayList<Purchase>();
	
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public List<Purchase> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
	
	
	
	


	
	

}
