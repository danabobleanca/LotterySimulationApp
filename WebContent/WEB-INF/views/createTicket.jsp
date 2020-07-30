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
			<div id="lotto_types"><h4>LOTTO TYPES</h4>
				<p>LOTO 10/20</p>
				<p>LOTO 5/35</p>
				<p>LOTO 7/49</p>
			</div>
			<div id="numbers_choosed"><h4>CREATE TICKET</h4>
				<form action="/LotteryApp/ticketCreated" method="post" id="createTicketContainer">
					<div id="chosenNumbers">
					<h5>CHOSEN NUMBERS</h5>
					<c:forEach var="number" items="${chosenNumbers}" >
						<div><c:out value="${number}" /></div>
					</c:forEach>
					</div>
					<div id="ticketDetails">
						<div id="myTicket">
							<h5>CREATE TICKET</h5>
							<div>
								<h6>CHOOSE DATE OF THE BET</h6>
								<input type="radio" name="dateOfExtraction" value="05-07-2020" id="date1">
								<label for="date1">05-07-2020</label><br/>
								<input type="radio" name="dateOfExtraction" value="12-07-2020" id="date2">
								<label for="date2">12-07-2020</label><br/>
								<input type="radio" name="dateOfExtraction" value="19-07-2020" id="date3">
								<label for="date3">19-07-2020</label><br/><br/>
							</div>
							<label for="bet">BET AMOUNT</label>
							<input type="text" name="bet" id="bet"/>
							<input type="submit" value="Create ticket" />
							
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>