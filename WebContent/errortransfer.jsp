<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>Enter valid amount.</h5>
<form action="http://localhost:8081/BankApp/Transfer">
<table>
		<tr>
			<td><label>Third Party Account No</label></td>
			<td><input type="text" name="TPAC" required/></td>
		</tr>
		<tr>
			<td><label>Amount</label></td>
			<td><input type="text" name="AMT" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="SUBMIT"/></td>
		</tr>
	</table>
	</form>
</body>
</html>