package com.obs.customer.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.obs.helper.sequenceGeneration.StringSequence;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "cart_seq")
    @GenericGenerator(name="cart_seq",
            strategy = "com.obs.helper.sequenceGeneration.StringSequence",
            parameters = {
                    @Parameter(name=StringSequence.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringSequence.VALUE_PREFIX_PARAMETER,value="Cart_"),
                    @Parameter(name=StringSequence.NUMBER_FORMAT_PARAMETER,value="%04d")
            }
            )
	private String cartId;
	private String bookId;
	private String custId;
	private String bookName;
	private BigDecimal bookPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BigDecimal getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	

}
