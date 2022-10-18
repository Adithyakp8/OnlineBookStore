<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/admin/bookPreView.css" rel="stylesheet" type="text/css">
</head>
<body>
	<ul>
		<li><a href="backToAdminHome">Home</a></li>
		<li><a href="editBook?bookId=${book.bookId}">Back</a></li>
	</ul>

	<div class="container">
		<embed class="embedClass" src="/bookPdf/${book.bookId}.pdf" type="application/pdf"
			width="100%" height="1010px" />
	</div>
	<div class="bootomNavBar">
		<p  align="center">©Copyright
			OnlineBookStore Virtusa</p>
	</div>
</body>
</html>