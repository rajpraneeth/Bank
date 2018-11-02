package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

public class Statement extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session=request.getSession();
			int accno=(int)session.getAttribute("accno");
			
			DAOModel dao=new DAOModel();
			dao.setAccno(accno);
			
			ArrayList al=dao.getStatement();
			if(al==null)
			{
				response.sendRedirect("statementFail.jsp");
			}
			else
			{
		    session.setAttribute("al", al);
			response.sendRedirect("statementSuccess.jsp");
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
