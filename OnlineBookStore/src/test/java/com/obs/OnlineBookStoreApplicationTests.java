package com.obs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.obs.admin.dao.AdminDao;
import com.obs.admin.model.Admin;
import com.obs.admin.service.AdminService;
import com.obs.book.dao.BookDao;
import com.obs.book.model.Book;
import com.obs.book.service.BookService;
import com.obs.customer.dao.CartDao;
import com.obs.customer.dao.CustomerDao;
import com.obs.customer.model.Customer;
import com.obs.customer.service.CustomerService;

@SpringBootTest
class OnlineBookStoreApplicationTests {
	@Autowired
	private BookService bookservice;
	
	@Autowired 
	private CustomerService custservice;
	
	@Autowired
	private CustomerDao custdao;
	
	@Autowired
	private CartDao cartdao;
	
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private AdminService adminservice;

	@Autowired
	private BookDao bookdao;
	
	@Test
	public void testLogin1() {
		Admin admin = new Admin();
		admin.setAdminEmail("ebookopolis@gmail.com");
		admin.setAdminPassword("ebookopolis");
		assertNotNull(adminservice.login(admin));
	}
	
	@Test
	public void testGetAllBooks1() {
		assertTrue(adminservice.getAllBooks().size()>0);
	}
	
	@Test
	public void testGetBook() {
		Book book = new Book();
		book.setBookId("Book_0001");
		assertNotNull(adminservice.getBook(book));
	}
	
	@Test
	public void testUpdateBook() {
		Book book = new Book();
		book.setBookId("Book_0001");
		book.setBookName("The Alchemist");
		book.setBookAuthor("Paulo coehlo");
		book.setBookGenre("mystery");
		book.setBookISBN("978-3-16-148410-0");
		book.setBookPublisher("Harper Torch");
		book.setBookPublishedOn("1988-08-11");
		int n = 345;
		BigDecimal bd = new BigDecimal(n);
		book.setBookPrice(bd);
		adminservice.updateBook(book);
		assertEquals("mystery",bookdao.findById("Book_0001").get().getBookGenre());
	}
	
	@Test
	public void testDeleteBook() {
		Book book = new Book();
		book.setBookId("Book_0009");
		adminservice.deleteBook(book);
		assertThat(bookdao.existsById("Book_0009")).isFalse();
		
	}
	
	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin();
		admin.setAdminId("Ad_0002");
		admin.setAdminEmail("ebookopolis@gmail.com");
		admin.setAdminMobile("9876543211");
		admin.setAdminName("E-Bookopolis");
		admin.setAdminPassword("ebookopolis");
		adminservice.updateAdmin(admin);
		assertEquals("9876543211",admindao.findById("Ad_0002").get().getAdminMobile());
	}
	
	@Test
	public void testSearch1() {
		assertNotNull(adminservice.search("Lolita"));
	}

	@Test
	public void testSearch() {
		assertNotNull(bookservice.search("Lolita"));
	}
	
	@Test
	public void testLogin() {
		Customer customer = new Customer();
		customer.setCustEmail("test@gmail.com");
		customer.setCustPassword("test@123");
		assertNotNull(custservice.login(customer));
		
	}
	
	@Test
	public void testGetAllBooks() {
		assertTrue(custservice.getAllBooks().size()>0);
	}
	
	@Test
	public void testSignUp() {
		Customer customer = new Customer();
		customer.setCustEmail("test@gmail.com");
		customer.setCustPassword("test123");
		customer.setCustName("test");
		customer.setCustMobile("8547479128");
		assertNotNull(custservice.signUp(customer));
		
	}
	@Test
	public void testAddToCart() {
		Customer customer = new Customer();
		Book book = new Book();
		customer.setCustId("Cust_0002");
		book.setBookId("Book_0001");
		assertNotNull(custservice.addToCart(customer, book));
		
	}
	
	@Test
	public void testGetCartItems() {
		Customer customer = new Customer();
		customer.setCustId("Cust_0002");
		assertTrue(custservice.getCartItems(customer).size()>0);
		
	}
	
	@Test
	public void testFindByCustEmail() {
		assertNotNull(custdao.findByCustEmail("test@gmail.com"));
	}
	
	@Test
	public void testFindByCustEmailAndPassword() {
		assertNotNull(custdao.findByCustEmailAndCustPassword("test@gmail.com","test123"));
	}
	
	@Test
	public void testUpdatecust() {
		Customer customer = new Customer();
		customer.setCustId("Cust_0002");
		customer.setCustEmail("test@gmail.com");
		customer.setCustPassword("test@123");
		customer.setCustName("test");
		customer.setCustMobile("8547419128");
		custservice.updatecust(customer);
		assertEquals("test@123",custdao.findById("Cust_0002").get().getCustPassword());
		
		
	}
	
	@Test
	public void testGetPurchaseItems() {
		Customer customer = new Customer();
		customer.setCustId("Cust_0002");
		assertTrue(custservice.getPurchaseItems(customer).size()>0);
		
	}
	
	@Test
	public void testGetPurchase() {
		custservice.getPurchase(cartdao.findAllByCustId("Cust_0002"),custdao.findById("Cust_0002").get());
		Customer customer = new Customer();
		customer.setCustId("Cust_0002");
		assertTrue(custservice.getPurchaseItems(customer).size()>0);
	}
	
	@Test
	public void testGetCustomer() {
		assertNotNull(custservice.getCustomer("Cust_0002"));
	}

}
