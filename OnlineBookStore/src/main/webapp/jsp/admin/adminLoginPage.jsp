<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="/css/admin/adminLoginPage.css" rel="stylesheet"
	type="text/css">
</head>
<body>
  <div class="login-wrapper">
    <form:form action="adminLogin" class="form" method="post" modelAttribute="admin">
      <!-- <img src="img/avatar.png" alt=""> -->
      <h2>Login</h2>
      <div class="input-group">
        <form:input type="text" path="adminEmail" id="adminEmail" required="required"/>
        <form:label path="adminEmail">User Name</form:label>
        <form:errors path="adminEmail" cssStyle="color:red" />
        <br><br>
      </div>
      <div class="input-group">
        <form:input type="password" path="adminPassword" id="adminPassword" required="required"/>
        <form:label path="adminPassword">Password</form:label>
        <form:errors path="adminPassword" cssStyle="color:red" />
      </div>
      <form:button type="submit" class="submit-btn">Login</form:button>
      <a href="#forgot-pw" class="forgot-pw">Forgot Password?</a>
      <br>
      <br>
      <div><%
				String a = (String) request.getAttribute("msg");
				if (a != null) {
					out.println("<p style='color:red;font-size:15px'>" + a + "</p>");
				}
				%>
	</div>
    </form:form>

    <div id="forgot-pw">
      <form action="" class="form">
        <a href="#" class="close">&times;</a>
        <h2>Reset Password</h2>
        <div class="input-group">
          <input type="email" path="email" id="email" required>
          <label for="email">Email</label>
        </div>
        <input type="submit" value="Submit" class="submit-btn">
      </form>
    </div>
  </div>
</body>

</html>