<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/admin/addBook.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
	<li><a href="backToAdminHome">Home</a></li>
</ul>
<br><br>
<div class="main" align="center">
<form:form method="post" modelAttribute="book" enctype="multipart/form-data">
	<fieldset>
    <legend>Book Details</legend>
    
    <form:label path="bookName">Book Name:&emsp;&emsp;&emsp;&nbsp;</form:label>
    <form:input  path="bookName" type="text" id="bookName" name="bookName" value="${book.bookName}"/>
    <form:errors path="bookName" cssStyle="color:red" /><br><br>
    <form:label path="bookAuthor">Book Author:&emsp;&emsp;&nbsp;&nbsp;</form:label>
    <form:input path="bookAuthor" type="text" id="bookAuthor" name="bookAuthor" value="${book.bookAuthor}"/>
    <form:errors path="bookAuthor" cssStyle="color:red" /><br><br>
    <form:label path="bookGenre">Book Genre:&emsp;&emsp;&emsp;</form:label>
    <form:input path="bookGenre" type="text" id="bookGenre" name="bookGenre" value="${book.bookGenre}"/>
    <form:errors path="bookGenre" cssStyle="color:red" /><br><br>
    <form:label path="bookPublisher">Book Publisher:&emsp;&ensp;</form:label>
    <form:input path="bookPublisher" type="text" id="bookPublisher" name="bookPublisher" value="${book.bookPublisher}"/>
    <form:errors path="bookPublisher" cssStyle="color:red" /><br><br>
    <form:label path="bookPublishedOn">Book PublishedOn:</form:label>
    <form:input path="bookPublishedOn" type="text" id="bookPublishedOn" name="bookPublishedOn" value="${book.bookPublishedOn}"/>
    <form:errors path="bookPublishedOn" cssStyle="color:red" /><br><br>
    <form:label path="bookISBN">Book ISBN:&emsp;&emsp;&emsp;&ensp;</form:label>
    <form:input path="bookISBN" type="text" id="bookISBN" name="bookISBN" value="${book.bookISBN}"/>
    <form:errors path="bookISBN" cssStyle="color:red" /><br><br>
    <form:label path="bookPrice">Book Price:&emsp;&emsp;&emsp;&ensp;</form:label>
    <form:input path="bookPrice" type="text" id="bookPrice" name="bookPrice" value="${book.bookPrice}"/>
    <form:errors path="bookPrice" cssStyle="color:red" /><br><br>
    
    <label for="coverPage">Upload Cover Page:</label>
    <input type="file" name="coverPage"/><br /><br>

    <label for="bookPdf">Upload Book:&emsp;&emsp;&ensp;</label>
    <input type="file" name="bookPdf"/><br /><br>
    <button formaction="addBook" type="submit" value="Add">Add</button>
     <div><%
				String a = (String) request.getAttribute("m");
				if (a != null) {
					out.println("<p style='color:red;font-size:15px'>" + a + "</p>");
				}
				%>
	</div>
  </fieldset>
  </form:form>
</div>
<div class="bootomNavBar">
	<p  align="center">©Copyright OnlineBookStore Virtusa</p>
	</div>

</body>
</html>