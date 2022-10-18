package com.obs.book.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.obs.helper.sequenceGeneration.StringSequence;

@Entity
public class Book {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "book_seq")
    @GenericGenerator(name="book_seq",
            strategy = "com.obs.helper.sequenceGeneration.StringSequence",
            parameters = {
                    @Parameter(name=StringSequence.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringSequence.VALUE_PREFIX_PARAMETER,value="Book_"),
                    @Parameter(name=StringSequence.NUMBER_FORMAT_PARAMETER,value="%04d")
            }
     )
	private String bookId;
	@NotEmpty
	@Column(nullable = false)
	private String bookName;
	
	@NotEmpty
	@Column(nullable = false)
	private String bookAuthor;
	
	@NotEmpty
	@Column(nullable = false)
	private String bookGenre;
	
	@NotEmpty
	@Column(nullable = false)
	private String bookPublisher;
	
	@NotEmpty
	@Column(nullable = false)
	private String bookPublishedOn;
	
	@NotEmpty
	@Column(nullable = false)
	private String bookISBN;
	

	@Column(nullable = false)
	@NotNull(message = "must not be empty")
	private BigDecimal bookPrice;
	
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookPublishedOn() {
		return bookPublishedOn;
	}
	public void setBookPublishedOn(String bookPublishedOn) {
		this.bookPublishedOn = bookPublishedOn;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public BigDecimal getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	

}
