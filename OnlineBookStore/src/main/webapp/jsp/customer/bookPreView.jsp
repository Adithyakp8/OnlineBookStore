<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/customer/bookPreView.css" />
<title>Browser</title>

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
		<embed class="embedClass" src="/bookPdf/${book.bookId}.pdf"
			type="application/pdf" width="100%" height="1010px" />
	</div>
	<div class="bootomNavBar">
	<p  align="center"> <b>&#169; Copyright OnlineBookStore Virtusa <b></p>
	</div>
</body>

</html>