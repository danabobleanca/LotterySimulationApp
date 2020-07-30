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
			<form:form action="/LotteryApp/welcome" method="post" modelAttribute="loginDetails">
				<label for="email">Email: </label>
				<form:input path="email" id="email"/><br/>
				<form:errors path="email" class="errors"></form:errors>
				<br/><br/>
				<label for="password">Password: </label>
				<form:input path="password" type="password" id="password"/><br/>
				<form:errors path="password" class="errors"></form:errors>
				<br>
				<input type="submit" value="LOGIN" id="submitBtn"/>
			</form:form>
			
		</div>
	</div>
</body>
</html>