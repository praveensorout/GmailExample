package login;
import datavalidation.DataValidation;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


/**
 * Servlet implementation class LogIn
 */
@WebServlet("/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		session.setAttribute("usermail",email);
		String password = request.getParameter("password");
		
		DataValidation d = new DataValidation();
		d.setEmail(email);
		d.setPassword(password);
		
		if(d.login())
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request , response);
		}
		else
		{
			out.print("invalid user");
		}
	}

}
