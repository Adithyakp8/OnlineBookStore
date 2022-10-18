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
<link rel="stylesheet" href="/css/customer/custOrders.css" />
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
		</div>
	</nav>


	<div class="container">
		<c:forEach var="book" items="${purchases}">

			<a class="card" href="customerViewBook?bookId=${book.bookId}">
				<div
					style="background:url(images/admin/${book.bookId}.jpg) no-repeat;background-size:cover"
					class="bookView">
					<p class="cardName" style="text-align: center">${book.bookName}</p>
				</div>
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
	<div class="bootomNavBar">
		<p align="center">
			<b>&#169; Copyright OnlineBookStore Virtusa <b>
		</p>
	</div>
</body>


</html>