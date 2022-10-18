<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined"
	rel="stylesheet" />
<link rel="stylesheet" href="/css/customer/style3.css" />
<title>Browser</title>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<script>
                function openSlideMenu() {
                    document.getElementById('menu').style.width = '250px';
                    document.getElementById('content').style.marginLeft = '-300px';
                }
                function closeSlideMenu() {
                    document.getElementById('menu').style.width = '0';
                    document.getElementById('content').style.marginLeft = '-300px';
                }
            </script>

</head>

<body>
	<nav class="navbar">
		<div class="nav">
			<a href="backToHome"> <img src="/images/customer/blogo-c.png"
				class="brand-logo" alt="">
			</a>
			<div id="content">
				<span class="slide"> <a href="#" onclick="openSlideMenu()">
						<i class="fas fa-bars"></i>
				</a>
				</span>
				<div id="menu" class="nav12">
					<a href="#" class="close" onclick="closeSlideMenu()"> <i
						class="fas fa-times"></i>
					</a> <a href="backToHome">Home</a> <a href="about">About</a> <a
						href="contact">Contact</a>
				</div>
			</div>

			<div class="nav-items">
				<div class="search">
					<form>
						<input type="text" name="term" class="search-box"
							placeholder="search Book, Author, Genre......">
						<button formaction="search" class="search-btn" type="submit">search</button>
					</form>
				</div>
				<div>
					<ul>
						<li><a href="#"> <img src="/images/customer/user.png"
								alt=""></a>
							<ul>
								<li class="sub-item"><span class="material-icons-outlined">
										format_list_bulleted </span> <a href="orders">
										<p>My Books</p>
								</a></li>
								<li class="sub-item"><span class="material-icons-outlined">
										manage_accounts </span> <a href="updatedetails">
										<p>Update Profile</p>
								</a></li>
								<li class="sub-item"><span class="material-icons-outlined">
										logout </span> <a href="logout">
										<p>Logout</p>
								</a></li>
							</ul></li>
					</ul>
				</div>

				<a href="viewcart"><img src="/images/customer/cart.png" alt=""></a>
			</div>
		</div>
	</nav>
	<p class="categoryName">
	<%
				if (!request.getAttribute("size").equals(0)) {
					out.println("Recomendation:");
				}
	%>
	</p>
	<div class="container">
		<c:forEach var="book" items="${recomends}">
			<a class="card" href="showBook?bookId=${book.bookId}">
				<div
					style="background:url(images/admin/${book.bookId}.jpg) no-repeat;background-size:cover"
					class="bookView"></div>
				<p class="cardName">${book.bookName}</p>
				<p class="product-short-des">${book.bookAuthor}</p>
				<p class="cardPrice">Rs. ${book.bookPrice}</p>
			</a>
		</c:forEach>
	</div>
	<p class="categoryName" style="margin-top:20px;">Books:</p>
	<div class="container">
		<c:forEach var="book" items="${bookList}">
			<a class="card" href="showBook?bookId=${book.bookId}">
				<div
					style="background:url(images/admin/${book.bookId}.jpg) no-repeat;background-size:cover"
					class="bookView"></div>
				<p class="cardName">${book.bookName}</p>
				<p class="product-short-des">${book.bookAuthor}</p>
				<p class="cardPrice">Rs. ${book.bookPrice}</p>
			</a>
		</c:forEach>
	</div>

	<script>
                const productContainers = [...document.querySelectorAll('.product-container')];
                const nxtBtn = [...document.querySelectorAll('.nxt-btn')];
                const preBtn = [...document.querySelectorAll('.pre-btn')];

                productContainers.forEach((item, i) => {
                    let containerDimensions = item.getBoundingClientRect();
                    let containerWidth = containerDimensions.width;

                    nxtBtn[i].addEventListener('click', () => {
                        item.scrollLeft += containerWidth;
                    })

                    preBtn[i].addEventListener('click', () => {
                        item.scrollLeft -= containerWidth;
                    })
                })
                let submenu = document.getElementById("subMenu");

                function toggleMenu() {
                    submenu.classList.toggle("openMenu")
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
	<div class="bootomNavBar">
		<p align="center">
			<b>&#169; Copyright OnlineBookStore Virtusa <b>
		</p>
	</div>
</body>

</html>