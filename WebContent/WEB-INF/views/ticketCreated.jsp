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
			<div id="numbers_choosed"><h4>TICKET CREATED</h4>
				<form>
					<div id="ticketCreated">
					<table>
						<thead>
							<tr><td colspan="5">TICKET</td></tr>
							<tr>
								<td>Bet</td>
								<td>Total Numbers Chosen</td>
								<td>Chosen Numbers</td>
								<td>Possible Win</td>
								<td>Date of Extraction</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${bet}</td>
								<td>${chosenTotalNumbers}</td>
								<td><c:forEach var="number" items="${lottoNo}">
									<span><c:out value="${number}"/></span>
								</c:forEach></td>
								<td>${possibleWin}</td>
								<td>${dateOfExtraction}</td>
							</tr>
						</tbody>
					</table>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>