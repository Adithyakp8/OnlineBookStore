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
<link rel="stylesheet" href="/css/customer/cart.css" />
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
	<h2>Your Cart</h2>
	<div align="center">
		<%
				String a = (String) request.getAttribute("msg");
				if (a != null) {
					out.println("<p style='color:red;font-size:30px;font-weight:50;'>" + a + "</p>");
				}
		%>
	</div>

	<div class="container">
		<c:forEach var="cart" items="${carts}">

			<div class="card">
				<div
					style="background:url(images/admin/${cart.bookId}.jpg) no-repeat;background-size:cover"
					class="bookView"></div>

				<p class="cardName">${cart.bookName}</p>
				<p class="cardPrice">Rs. ${cart.bookPrice}</p>
				<a href="emptycart?cartId=${cart.cartId}">
					<button>Remove From Cart</button>
				</a>

			</div>


		</c:forEach>

	</div>


	</div>
	<div class="cart-container">

		<h2>Cart Total</h2>
		<table>
			<thead>
				<tr>
					<th><strong>Product</strong></th>
					<th><strong>Price</strong></th>
				</tr>
			</thead>
			<tbody id="carttable">
			</tbody>
		</table>
		<hr>
		<table id="carttotals">
			<tr>
				<td><strong>Items</strong></td>
				<td><strong>Total</strong></td>
			</tr>
			<c:forEach var="cart" items="${carts}">
				<tr>
					<td>x <span id="itemsquantity">1</span></td>

					<td>Rs. <span id="total">${cart.bookPrice}</span></td>


				</tr>
			</c:forEach>
		</table>
		<div class="couponBox">
		<div class="coupon">
		<form>
			<input type="text" placeholder="Enter Coupon Code" name="couponName">
			<button formaction="applyCoupon" >Apply</button>
		</form>
		</div>
		<div class="actualPrice">
		<h3>Total: Rs.${total}</h3>
		<h3>Actual Total: Rs.${total-coupon}</h3>
		</div>
		</div>

		<div class="cart-buttons">

			<form>
				<button formaction="emptyall" id="emptycart">Empty Cart</button>
			</form>

			<a href="purchase">
				<button id="checkout">Checkout</button>
			</a>
		</div>

	</div>
	</div>
	<!-- partial -->

	<!-- END EDMO HTML (Happy Coding!)-->
	</main>



	<script src="./js/script.js"></script>
	<div class="bootomNavBar">
		<p align="center">
			<b>&#169; Copyright OnlineBookStore Virtusa <b>
		</p>
	</div>
</body>
</html>