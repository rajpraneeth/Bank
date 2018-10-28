<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Welcom"+ session.getAttribute("name")+" You have logged in sucessfully");
%>
<br/><br/>
<label>
	<tr>
		<td><a href="Balance.jsp">Balance Check</a>
	</tr>
	<tr>
		<td><a href="transfer.jsp">Amount transfer</a></td>
	</tr>
	<tr>
		<td><a href="">Change password</a></td>
	</tr>
	<tr>
		<td><a href="">Apply for a Loan </a></td>
	</tr>
</label>
</body>
</html>