package composedata;
import datainbox.DataInbox;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import javax.servlet.http.*;

/**
 * Servlet implementation class Compose
 */
@WebServlet("/compose")
public class Compose extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String to = request.getParameter("to");
		String email = (String)session.getAttribute("usermail");
		String subj = request.getParameter("subj");
		String msg = request.getParameter("msg");
		Date d = new Date();
		String date = d.toString();
		
		DataInbox dI = new DataInbox();
		dI.setTo(to);
		dI.setEmail(email);
		dI.setSubj(subj);
		dI.setMsg(msg);
		dI.setDate(date);
		
		if(dI.addData())
		{
			out.print("user already logged in");
		}
		else
		{
			response.sendRedirect("sent.jsp");
		}
	}

}
