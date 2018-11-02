package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

public class Transfer extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			int tpac=Integer.parseInt(request.getParameter("TPAC"));
			int amt=Integer.parseInt(request.getParameter("AMT"));
			
			DAOModel dao=new DAOModel();
			HttpSession session=request.getSession();
			int accno=(int)session.getAttribute("accno");
			dao.setAccno(accno);
			Boolean temp=dao.amountTransfer(amt);
			
			if(temp==true)
			{
				response.sendRedirect("transferSuccess.jsp");
			}
			else
			{
				response.sendRedirect("transferFailure.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
