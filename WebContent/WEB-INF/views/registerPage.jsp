<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="style.css" %></style>
</head>
<body>
	<div class="container" id="login_container">
		<h4>Hello! Welcome to LOTTO!</h4>
		<hr/>
		<div id="authentification_page">
			<form:form action="/LotteryApp/registerState" method="post" modelAttribute="registerDetails">
				<label for="name">Name: </label>
				<form:input path="name" id="name"/><br/>
				<form:errors path="name" class="errors" ></form:errors><br/><br/>
				
				<label for="cnp">CNP: </label>
				<form:input path="cnp" id="cnp"/><br/>
				<form:errors path="cnp" class="errors"></form:errors><br/><br/>
				
				<label for="address">Address</label>
				<form:input path="address" id="address"/><br/>
				<form:errors path="address" class="errors" ></form:errors><br/><br/>
				
				<label for="address">Email</label>
				<form:input path="login.email" id="email"/><br/>
				<form:errors path="login.email" class="errors"></form:errors><br/><br/>
				
				<label for="password">Password</label>
				<form:input path="login.password" type="password" id="password"/><br/>
				<form:errors path="login.password"  class="errors"></form:errors><br/><br/>
				<input type="submit" value="REGISTER" id="submitBtn"/>
			
			</form:form>
			
		</div>
	</div>
</body>
</html>