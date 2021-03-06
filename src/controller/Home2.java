package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

public class Home2 extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			int temp1=Integer.parseInt(request.getParameter("CID"));
			String temp2=request.getParameter("PW");
			
			DAOModel dao=new DAOModel();
			dao.setCustid(temp1);
			dao.setPassword(temp2);
			
			Boolean temp=dao.login();
			if(temp==true)
			{
				HttpSession session =request.getSession(true);
				session.setAttribute("accno",dao.getAccno());
				session.setAttribute("name", dao.getName());
				response.sendRedirect("proceed.jsp");
			}
			else
			{
				response.sendRedirect("invalid.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
