package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOModel;

public class ChangePasword extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		  HttpSession session=request.getSession();
		  int accno=(int)(session.getAttribute("accno"));
		  String opw=request.getParameter("OPW");
		  String npw=request.getParameter("NPW");
		  
		  DAOModel dao=new DAOModel();
		  dao.setPassword(opw);
		  dao.setAccno(accno);
		  Boolean temp=dao.changePassword(npw);
		  if(temp==true)
		  {
			  response.sendRedirect("changePasswordSuccess.jsp");
		  }
		  else
		  {
			  response.sendRedirect("changePasswordFailure.jsp");
		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
