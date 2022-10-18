<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/admin/updateAdmin.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
	<li><a href="backToAdminHome">Home</a></li>
</ul>
<div class="main" align="center">
	<form:form method="post" modelAttribute="adm">
	<fieldset>
    <legend>Update Details</legend>
    <form:label path="adminName">Name:</form:label>
    <form:input path="adminName" type="text" id="adminName" name="adminName" value="${admin.adminName}"/><br>
    <form:errors path="adminName" cssStyle="color:red" /><br><br>
    <form:label path="adminMobile">Mobile:</form:label>
    <form:input path="adminMobile" type="text" id="adminMobile" name="adminMobile" value="${admin.adminMobile}"/>
    <form:errors path="adminMobile" cssStyle="color:red" /><br><br>
    <form:label path="adminPassword">Password:</form:label>
    <form:input path="adminPassword" type="text" id="adminPassword" name="adminPassword" value="${admin.adminPassword}"/>
    <form:errors path="adminPassword" cssStyle="color:red" /><br><br>
    <button formaction="updateAdmin" type="submit" value="Update">Update</button>
  </fieldset>
  </form:form>
</div>
<div class="bootomNavBar">
	<p  align="center">©Copyright OnlineBookStore Virtusa</p>
	</div>
</body>
</html>