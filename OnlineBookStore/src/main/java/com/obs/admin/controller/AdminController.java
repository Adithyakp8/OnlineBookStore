package com.obs.admin.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.obs.admin.exception.InvalidInputException;
import com.obs.admin.model.Admin;
import com.obs.admin.service.AdminService;
import com.obs.book.exception.EmptySearchException;
import com.obs.book.exception.NoBookFoundException;
import com.obs.book.model.Book;
import com.obs.coupon.model.Coupon;

@Controller
public class AdminController {
	
	
	Logger log = LoggerFactory.getLogger(AdminController.class);

	
	@Autowired
	private AdminService adminservice;
	
	@PostMapping("adminLogin")
	public String adminLogin(@Valid @ModelAttribute Admin admin, BindingResult br, HttpSession session, Model map) {
		if(br.hasErrors()) {
			log.warn("Invalid details, Check once more");
			return "admin/adminLoginPage";
		}
		Admin admintemp = adminservice.login(admin);
		session.setAttribute("admin", admintemp);
		map.addAttribute("bookList",adminservice.getAllBooks());
		log.info("Admin Loggedin Successfully");
		return "admin/adminHome";
	}
	
	@RequestMapping("editBook")
	public String editBook(Book book, Model map, HttpSession session) {
		map.addAttribute("book", adminservice.getBook(book));
		session.setAttribute("bookId", book.getBookId());
		return "admin/editBook";
	}
	
	@RequestMapping("updateBook")
	public String updateBook(@RequestParam("coverPage") MultipartFile coverPage,@RequestParam("bookPdf") MultipartFile bookPdf, @Valid @ModelAttribute("book") Book book, BindingResult br,HttpSession s) {
		if (br.hasErrors())
			return "admin/editBook";
		String bId = (String) s.getAttribute("bookId");
		book.setBookId(bId);
		adminservice.updateBook(book);
		try {
			if(coverPage.isEmpty()) {
				log.warn("Image Folder is empty");
			}
			// read and write the file to the selected location-
			else {
				byte[] bytes1 = coverPage.getBytes();
				Path path1 = Paths.get("src//main//resources//static//images//admin//" + book.getBookId()+".jpg");
				Files.write(path1, bytes1);
			}
			
			if(bookPdf.isEmpty()) {
				log.warn("Book Folder is empty");
			}
			// read and write the file to the selected location-
			else {
				byte[] bytes2 = bookPdf.getBytes();
				Path path2 = Paths.get("src//main//resources//static//bookPdf//" + book.getBookId()+".pdf");
				Files.write(path2, bytes2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:refreshAdminHome";
	}
	
	@RequestMapping("deleteBook")
	public String deleteBook(Book book,Model map,HttpSession session) {
		String bId = (String)session.getAttribute("bookId");
		book.setBookId(bId);
		adminservice.deleteBook(book);
		try {
			// read and write the file to the selected location-
//			byte[] bytes = file.getBytes();
			Path path1 = Paths.get("src//main//resources//static//images//admin//" + book.getBookId()+ ".jpg");
			Files.deleteIfExists(path1);
			
			Path path2 = Paths.get("src//main//resources//static//bookPdf" + book.getBookId()+ ".pdf");
			Files.deleteIfExists(path2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:refreshAdminHome";
	}
	
	@RequestMapping("adminLogOut")
	public String adminLogOut(@ModelAttribute Admin admin, HttpSession session) {
		session.invalidate();
		log.info("Admin LoggedOut Successfully");
		return "admin/adminLoginPage";
	}
	
	@RequestMapping("backToAdminHome")
	public String backToAdminHome(Model map) {
		map.addAttribute("bookList",adminservice.getAllBooks());
		return "admin/adminHome";
	}
	
	@RequestMapping("addBookForm")
	public String addBookForm(Model m) {
		m.addAttribute("book", new Book());
		return "admin/addBook";
	}
	
	
	@RequestMapping("addBook")
	public String addBook(@RequestParam("coverPage") MultipartFile coverPage,@RequestParam("bookPdf") MultipartFile bookPdf, RedirectAttributes redirectAttributes,@Valid @ModelAttribute("book") Book book, BindingResult br) {
		if(br.hasErrors())
			return "admin/addBook";
		try {
			if(book.getBookPrice()==null) {
				log.error("Price is null");
				throw new InvalidInputException("addBook");
			}else {
				log.info("Book added Successfully");
				adminservice.addBook(book);
			}
			// read and write the file to the selected location-
			byte[] bytes1 = coverPage.getBytes();
			Path path1 = Paths.get("src//main//resources//static//images//admin//" + book.getBookId()+".jpg");
			Files.write(path1, bytes1);
			
			// read and write the file to the selected location-
			byte[] bytes2 = bookPdf.getBytes();
			Path path2 = Paths.get("src//main//resources//static//bookPdf//" + book.getBookId()+".pdf");
			Files.write(path2, bytes2);

		} catch (IOException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		return "redirect:refreshAdminHome";
	}
	
	@RequestMapping("goToUpdateAdmin")
	public String goToUpdateAdmin(ModelMap m, HttpSession s) {
		Admin adm = (Admin) s.getAttribute("admin");
		m.addAttribute("adm", adm);
		return "admin/updateAdmin";
	}
	
	@RequestMapping("updateAdmin")
	public String updateAdmin(@Valid @ModelAttribute("adm") Admin adm,BindingResult br, HttpSession session,Model map) {
		if(br.hasErrors())
			return "admin/updateAdmin";
		Admin admin = (Admin) session.getAttribute("admin");
		admin.setAdminName(adm.getAdminName());
		admin.setAdminMobile(adm.getAdminMobile());
		admin.setAdminPassword(adm.getAdminPassword());
		adminservice.updateAdmin(admin);
		map.addAttribute("bookList",adminservice.getAllBooks());
		log.info("Admin Details updated Successfully");
		return "admin/adminHome";
	}
	
	@RequestMapping("refreshAdminHome")
	public String refreshAdminHome(Model map) {
		map.addAttribute("bookList",adminservice.getAllBooks());
		return "admin/adminHome";
	}
	
	@RequestMapping("viewBook")
	public String viewBook(Book book,Model map,HttpSession session) {
		book.setBookId((String)session.getAttribute("bookId"));
		map.addAttribute("book",book);
		return "admin/bookPreView";
		
	}
	
	@RequestMapping("backToEditBook")
	public String backToEditBook(Book book,Model map) {
		map.addAttribute("book",book);
		return "admin/editBook";
		
	}
	@RequestMapping("searchThroughAdmin")
	public String getSearch(@RequestParam("term") String term,Model map) {
		if(term.isEmpty())
			throw new EmptySearchException("admin");
		List<Book> flist = adminservice.search(term);
		if(flist.isEmpty())
			throw new NoBookFoundException("admin");
		map.addAttribute("bookList",flist);
		return "admin/adminHome";
		
	}
	
	@RequestMapping("coupon")
	public String getCouponAddPage(Model map) {
		map.addAttribute("coupons",adminservice.getCoupons());
		return "admin/coupon";
	}
	
	@RequestMapping("deleteCoupon")
	public String deleteCoupon(Coupon coupon,Model map) {
		adminservice.deleteCoupon(coupon);
		map.addAttribute("coupons",adminservice.getCoupons());
		return "admin/coupon";
		
	}
	
	@RequestMapping("addCoupon")
	public String addCoupon(Coupon coupon,Model map) {
		adminservice.addCoupon(coupon);
		map.addAttribute("coupons",adminservice.getCoupons());
		return "admin/coupon";
	}
	
	

}
