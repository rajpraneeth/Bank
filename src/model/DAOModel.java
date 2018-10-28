package model;

import java.sql.*;

public class DAOModel 
{
  Connection con=null;
  PreparedStatement pstml=null;
  ResultSet res=null;
  
  private int accno=0;
  private int custid=0;
  String name =null;
  private String password =null;
  private int balance=0;
  String email=null;
  
	public int getAccno() 
	{
		return accno;
	}
	public void setAccno(int accno) 
	{
		this.accno = accno;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) 
	{
		this.custid = custid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public int getBalance() 
	{
		return balance;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
  

	public DAOModel()
	{
		DBConnector dbc =new DBConnector();
		con= dbc.giveConnection();
	}
	
	public Boolean login()
	{
		try{
			pstml = con.prepareStatement("SELECT* FROM MAY_BANK WHERE CUSTOMER_ID=? PASSWORD=?");
			pstml.setInt(1,custid);
			pstml.setString(2,password);
			res= pstml.executeQuery();
			
			while(res.next()==true)
			{
				name =res.getString("CUSTOMER_NAME");
				res.getInt("ACCOUNT_NO");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean checkBalance()
	{
		try
		{
			pstml=con.prepareStatement("SELECT BALANCE FROM MAY_BANK WHERE ACCOUNT_NO=?");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
  
}
