<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/admin/coupon.css" rel="stylesheet" type="text/css">
</head>
<body>
	<ul>
		<li><a href="backToAdminHome">Home</a></li>
	</ul>
	<br>
	<br>
	<div class="main" align="center">
		<form>
		<input type="text" id = "couponName" name="couponName" placeholder="Enter Coupon name">
		<input type="text" id = "couponPrice" name="couponPrice" placeholder="Enter Coupon price">
		<button formaction="addCoupon">Add Coupon</button>
		</form>
		<br>
		<br><br>
		
		<table>
			<tr>
				<th>Coupon Name</th>
				<th>Coupon Price</th>
				<th>Delete Coupon</th>
			</tr>
			<c:forEach var="coupon" items="${coupons}">
				<tr>
					<td>${coupon.couponName}</td>
					<td>${coupon.couponPrice}</td>
					<td><a href="deleteCoupon?couponId=${coupon.couponId}"><Button>Delete</Button></a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="bootomNavBar">
		<p align="center">©Copyright OnlineBookStore Virtusa</p>
	</div>

</body>
</html>