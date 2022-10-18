<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- Created By Code4Education -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Navbar </title>
    <link rel="stylesheet" href="/css/admin/adminHome.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  </head>
  <body>
    <nav> 
      <div class="menu-icon">
        <span class="fas fa-bars"></span>
      </div>

      <div class="logo"><a style="color: white; text-decoration:none;"href="backToAdminHome">E-Bookopolis</a></div>

      <div class="nav-items">
        <li><a href="addBookForm">Add Book</a></li>
        <li><a href="coupon">Coupon</a></li>
        <li><a href="goToUpdateAdmin">Update Admin</a></li>
        <li><a href="adminLogOut">LogOut</a></li>
      </div>

      <div class="search-icon">
        <span class="fas fa-search"></span>
      </div>

      <div class="cancel-icon">
        <span class="fas fa-times"></span>
      </div>

      <form action="searchThroughAdmin">
        <input type="search" class="search-data" placeholder="Search" name="term">
        <button type="submit" class="fas fa-search"></button>
      </form>

    </nav>
    
    
    <div class="container">
			<c:forEach var="book" items="${bookList}">
				<a class="card" href="editBook?bookId=${book.bookId}">
					<div
						style="background:url(images/admin/${book.bookId}.jpg) no-repeat;background-size:cover"
						class="bookView"></div>
					<div class="product-info">
						<h4 class="product-brand">${book.bookName}</h4>
						<p class="product-short-des">${book.bookAuthor}</p>
						<span class="price">${book.bookPrice}</span>
					</div>

				</a>
			</c:forEach>
		</div>
		
		
		<div class="bootomNavBar" align="center">
			<p>©Copyright OnlineBookStore Virtusa</p>
		</div>
		
		
     
    <script>
      const menuBtn = document.querySelector(".menu-icon span");
      const searchBtn = document.querySelector(".search-icon");
      const cancelBtn = document.querySelector(".cancel-icon");
      const items = document.querySelector(".nav-items");
      const form = document.querySelector("form");
      menuBtn.onclick = ()=>{
        items.classList.add("active");
        menuBtn.classList.add("hide");
        searchBtn.classList.add("hide");
        cancelBtn.classList.add("show");
      }
      cancelBtn.onclick = ()=>{
        items.classList.remove("active");
        menuBtn.classList.remove("hide");
        searchBtn.classList.remove("hide");
        cancelBtn.classList.remove("show");
        form.classList.remove("active"); 
      }
      searchBtn.onclick = ()=>{
        form.classList.add("active");
        searchBtn.classList.add("hide");
        cancelBtn.classList.add("show");
      }
    </script>
    <div align="center">
		<%
				String a = (String) request.getAttribute("msg");
				if (a != null) {
					out.println("<p style='color:red;font-size:30px;font-weight:50;'>" + a + "</p>");
				}
				%>
	</div>
  </body>
</html>