package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordFilter implements Filter
{
    public ChangePasswordFilter() 
    {
      
    }

	public void destroy()
	{
		
	}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
		{
			String npw=request.getParameter("NPW");
			String cnpw=request.getParameter("CNPW");
			if(npw.equals(cnpw)==true)
			{
				chain.doFilter(request, response);
	        }
			else
			{
				((HttpServletResponse)(response)).sendRedirect("ChangePasswordError.jsp");
			}
		}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
