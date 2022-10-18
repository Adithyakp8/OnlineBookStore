<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined"
      rel="stylesheet"
    />

  <link rel="stylesheet" href="/css/customer/style1.css" />
  <title>Browser</title>


  <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
  <script>
    function openSlideMenu(){
      document.getElementById('menu').style.width = '250px';
      document.getElementById('content').style.marginLeft = '-300px';
    }
    function closeSlideMenu(){
      document.getElementById('menu').style.width = '0';
      document.getElementById('content').style.marginLeft = '-300px';
    }
  </script>
</head>

<body>
  <body>
    <nav class="navbar">
  <div class="nav">
  
  <a href="backToHome">
  
      <img src="/images/customer/blogo-c.png" class="brand-logo" alt="">
      </a>
  </div>
  </nav>

      <section class="SignUp">

        <div class="signup-box">
          <h1>Update Details</h1>
          <h4></h4>
          <form:form action="updatecust" modelAttribute="cust">
            <form:label path="custName" >Name</form:label>
            <form:input path="custName" type="text" name="custName" value="${cust.custName}" />
            <form:errors path="custName" cssStyle="color:red" />
            <form:label path="custMobile" >MobileNumber</form:label>
            <form:input path="custMobile" type="text" name="custMobile" value="${cust.custMobile}" />
            <form:errors path="custMobile" cssStyle="color:red" />
            <form:label path="custPassword" >Confirm Password</form:label>
            <form:input path="custPassword" type="password" name="custPassword" value="${cust.custPassword}" /><br><br>
            <form:errors path="custPassword" cssStyle="color:red" />
            <input type="submit" value="Update"/>
          </form:form>
          
        

      </section>
<div class="bootomNavBar">
	<p  align="center"> <b>&#169; Copyright OnlineBookStore Virtusa <b></p>
	</div>
</body>

</html>