package model;

import java.sql.*;

import oracle.jdbc.OracleDriver;

public class DBConnector 
{
   String url="jbdc:oracle:thin:@//192.168.1.2:1521/XE";
   String un ="system";
   String pw ="system";
   Connection con =null;
   

public Connection giveConnection() {
	try{
		   DriverManager.registerDriver(new OracleDriver());
		   con = DriverManager.getConnection(url, un, pw);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return con;
}
}
