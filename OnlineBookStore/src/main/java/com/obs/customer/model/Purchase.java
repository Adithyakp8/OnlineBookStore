package com.obs.customer.model;

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
public class Purchase {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "pur_seq")
    @GenericGenerator(name="pur_seq",
            strategy = "com.obs.helper.sequenceGeneration.StringSequence",
            parameters = {
                    @Parameter(name=StringSequence.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringSequence.VALUE_PREFIX_PARAMETER,value="Pur_"),
                    @Parameter(name=StringSequence.NUMBER_FORMAT_PARAMETER,value="%04d")
            }
            )
	private String purchaseId;
	private String bookId;
	private String bookName;
	private String custId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
