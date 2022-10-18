<!-- 
Online HTML, CSS and JavaScript editor to run code online.
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
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

  <link rel="stylesheet" href="/css/customer/style2.css" />
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
  
      <img src="/images/customer/blogo-c.png" class="brand-logo" alt="">
  
  </div>
  
  
  
  </nav>

      <section class="Login">

        <div class="login-box">
            <h1>Login</h1>
            <form:form action="login" method="post" modelAttribute="cust">
				<form:label path="custEmail">Email</form:label>
				<form:input path="custEmail" type="text" placeholder="Enter your Registered Email..."/>
				<form:errors path="custEmail" cssStyle="color:red" />
				<form:label path="custPassword">Password</form:label>
				<form:input path="custPassword" type="password" placeholder="Enter your Registered password..."/>
				<br>
				<br>
				<form:errors path="custPassword" cssStyle="color:red" />
				<input type="submit" value="LogIn" />
			</form:form>
			<div>
			<%
				String a = (String) request.getAttribute("msg");
				if (a != null) {
					out.println("<p style='color:red;font-size:15px'>" + a + "</p>");
				}
				%>
			</div>
          </div>
          <br><br>
          <p class="para-2">
            Do Not have an account? <a href="signin">Sign Up Here</a>
          </p>

    </section>
<div class="bootomNavBar">
	<p  align="center"> <b>&#169; Copyright OnlineBookStore Virtusa <b></p>
	</div>
</body>

</html>