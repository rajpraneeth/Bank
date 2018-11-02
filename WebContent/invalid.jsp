<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proceed</title>
</head>
<body>
<h5>Login Failed. Customer ID or password is not correct.Try again!</h5>
<form action="http://localhost:8081/BankApp/Home2">

<table>
   <tr>
      <td><Label>CustomerID</Label></td>
      <td><input type="text" name="CID" required/></td>
   </tr>

   <tr>
      <td><Label>password</Label></td>
      <td><input type="password" name="PW" required/></td>
   </tr>

   <tr>
      <td><input type="submit" value="SUBMIT"/></td>
      <td><a href="foget.jsp">Forgot password ?</a></td>
   </tr>
</table>
</form>
</body>
</html>