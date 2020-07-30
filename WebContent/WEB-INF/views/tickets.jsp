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
				
					<div id="tickets">
					<table>
					<thead>
						<tr>
						 <td>Date Of Extraction</td>
						 <td>Bet Amount</td>
						 <td>Chosen Numbers</td>
						 <td>Total Win</td>
						 <td>Ticket State</td>
						 <td>System Numbers Extracted</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="ticket" items="${tickets}">
						<tr>
							<td><c:out value="${ticket.dateOfExtraction}" /> </td>
							<td><c:out value="${ticket.betAmount}"/> </td>
							<td>
								<c:forEach items="${ticket.chosenNumbers}" var="number">
									<c:out value="${number}"/>&nbsp 
								</c:forEach>
							</td>
							<td><c:out value="${ticket.totalWin}" /></td>
							<td><c:out value="${ticket.ticketState}" /></td>
							<td>
								<c:forEach var="systNumber" items="${ticket.lottoSystem.systemGeneratedNumbers}">
										<c:out value="${systNumber}" />&nbsp
								</c:forEach>
							</td>
						</tr> 
						</c:forEach>
					</tbody>
					</table>
					</div>
			</div>

		</div>
	</div>
</body>
</html>