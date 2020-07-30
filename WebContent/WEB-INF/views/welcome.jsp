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
			<div id="numbers"><h4>LOTTO NUMBERS TO CHOOSE - LOTTO 10/20</h4>
				<form action="/LotteryApp/createTicket" action="post">
				<div id="numbersLoto">
					<%
					for(int i=1;i<21;i++){
					%>
					<div id="box_numbers">
					 <label for="<%=i %>"><%=i %></label>
					<input type="checkbox" name="lottoNumbers" id="<%=i%>" value="<%=i%>" />
					</div>
					<%} %>
				<div id="createTicket"><input type="submit" value="CREATE TICKET"/></div>
				</div>
				</form>
			</div>
		<div id="tickets"><h4>TICKETS</h4>
			<table>
			<thead>
				<tr>
					<td>Date Of Extraction</td>
					<td>Bet Amount</td>
					<td>Total Win</td>
					<td>Ticket State</td>
				</tr>
			</thead>
			<c:forEach var="ticket" items="${listTickets}" >
				<tbody>
				<tr>
					<td><c:out value="${ticket.dateOfExtraction}" /></td>
					<td><c:out value="${ticket.betAmount}" /></td>
					<td><c:out value="${ticket.totalWin}" /></td>
					<td><c:out value="${ticket.ticketState}" /></td>
				</tr>
				</tbody>
			</c:forEach>
			</table>
			</div>
		</div>
	</div>
</body>
</html>