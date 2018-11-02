<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>change password</title>
</head>
<body>
<form action="http://localhost:8081/BankApp/ChangePasword ">
  <table>
    <tr>
       <td><label>Old Password</label></td>
       <td><input type="password" name="OPW" required/></td>
   </tr>

    <tr>
       <td><Label>New Password</Label></td>
       <td><input type="password" name="NPW" required/></td>
    </tr>
    
    <tr>
        <td><Label>Confirm New Password</Label></td>
        <td><input type="password" name="CNPW" required/></td>
    </tr>
  
    <tr>
         <td><input type="submit" value="SUBMIT"></td>
    </tr>
  </table>
</form>
</body>
</html>