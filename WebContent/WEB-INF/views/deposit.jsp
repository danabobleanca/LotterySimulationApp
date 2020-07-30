<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<div id="navigation">
			<div id="menu"><a href="/LotteryApp/loto">LOTTO</a></div>
			<div id="menu"><a href="/LotteryApp/tickets">TICKETS</a></div>
			<div id="menu"><a href="/LotteryApp/wallet">E-WALLET</a></div>
		</div>
			
		<div class="content_page">
			<div id="wallet_menu"><h4>WALLET</h4>
				<p><a href="/LotteryApp/wallet">BALANCE</a></p>
				<p><a href="/LotteryApp/deposit">DEPOSIT</a></p>
				<p><a href="/LotteryApp/withdraw">WITHDRAW</a></p>
			</div>
			<div id="wallet">
				<form action="/LotteryApp/paymentSuccess" method="post">
					<div id="deposit_page">
						
								<label for="card">Credit card number</label>
								<input type="text" name="card" id="card" required/><br/><br/>
								<label for="holder">Card holder name</label>
								<input type="text" name="holder" id="holder" required/><br/><br/>
								<label for="cvc">CVC</label>
								<input type="text" name="cvc" id="cvc" required/><br/><br/>
								<label for="amountDeposit">Value you want to transfer</label>
								<input type="text" name="amountDeposit" id="amountDeposit" required /><br/><br/>
								
								<input type="submit" value="DEPOSIT" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>