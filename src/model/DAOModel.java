package model;
import java.sql.*;
import java.util.ArrayList;

public class DAOModel 
{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	private int accno=0;
	private int custid=0;
	String name=null;
	private String password=null;
	private int balance=0;
	String email=null;
	
	public void setAccno(int accno) 
	{
		this.accno = accno;
	}
	public void setCustid(int custid) 
	{
		this.custid = custid;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public int getAccno() 
	{
		return accno;
	}
	public int getCustid() 
	{
		return custid;
	}
	public String getName()
	{
		return name;
	}
	public String getPassword() 
	{
		return password;
	}
	public int getBalance() 
	{
		return balance;
	}
	public String getEmail() 
	{
		return email;
	}
	
	public DAOModel()
	{
		DBConnector dbc=new DBConnector();
		con=dbc.giveConnection();
	}
	
	public Boolean login()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM MAY_BANK WHERE CUSTOMER_ID=? AND PASSWORD=?");
			pstmt.setInt(1, custid);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				name=res.getString("CUSTOMER");
				accno=res.getInt("ACCOUNT_NO");
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
			pstmt=con.prepareStatement("SELECT BALANCE FROM MAY_BANK WHERE ACCOUNT_NO=?");
			pstmt.setInt(1,accno);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				balance=res.getInt("BALANCE");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean amountTransfer(int amt)
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE MAY_BANK SET BALANCE=BALANCE-? WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, amt);
			pstmt.setInt(2, accno);
			int temp=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("INSERT INTO MAY_STATEMENT VALUES(?,?)");
			pstmt.setInt(1, accno);
			pstmt.setInt(2, amt);
			pstmt.executeUpdate();
			
			if(temp==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	 
	public Boolean changePassword(String npw)
	{
		try
		{
			pstmt=con.prepareStatement("UPDATE MAY_BANK SET PASSWORD=? WHERE ACCOUNT_NO=? AND PASSWORD=?");
			pstmt.setString(1, npw);
			pstmt.setInt(2, accno);
			pstmt.setString(3, password);
			int temp=pstmt.executeUpdate();
			if(temp==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList getStatement()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM MAY_STATEMENT WHERE ACCOUNT_NO=?");
		    pstmt.setInt(1, accno);
		    res=pstmt.executeQuery();
		    ArrayList al=new ArrayList();
		    
		    while(res.next()==true)
		    {
		    	al.add(res.getInt("AMOUNT"));
		    }
		    return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}