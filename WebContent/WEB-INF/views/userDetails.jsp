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
			<h4>Email: <span>${userDetails.login.email}</span></h4>
			<h4>Password: <span>${userDetails.login.password}</span></h4>
			<h4>Name: <span>${userDetails.name}</span></h4>
			<h4>CNP:<span>${userDetails.cnp}</span></h4>
			<h4>Address: <span>${userDetails.address}</span></h4>
			
			<a href="/LotteryApp/loginPage"><button>Login to access your account</button></a>
		</div>
	</div>
</body>
</html>