package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

public class Balance extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session=request.getSession();
			int temp=(int) session.getAttribute("accno");
			DAOModel dao=new DAOModel();
			dao.setAccno(temp);
			
			Boolean balance=dao.checkBalance();
			if(balance==true)
			{
				HttpSession session1=request.getSession();
				session1.setAttribute("balance", dao.getBalance());
				response.sendRedirect("balanceSuccess.jsp");
			}
			else
			{
				response.sendRedirect("balanceFailure.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
