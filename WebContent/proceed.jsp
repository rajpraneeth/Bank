<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proceed</title>
</head>
<body>
<%
	out.println("Welcome "+session.getAttribute("name")+" You have logged in successfully");
%>
<br/><br/>
<table>
	<tr>
		<td><a href="Balance">Balance Check</a></td>
	</tr>
	<tr>
		<td><a href="transfer.jsp">Amount Transfer</a></td>
	</tr>
	<tr>
		<td><a href="changePassword.jsp">Change Password</a></td>
	</tr>
	<tr>
		<td><a href="loan.jsp">Apply for a Loan</a></td>
	</tr>
	<tr>
		<td><a href="Statement">Account Statement</a></td>
	</tr>
	<tr>
		<td><a href="logout.jsp">Logout</a></td>
	</tr>
</table>
</body>
</html>