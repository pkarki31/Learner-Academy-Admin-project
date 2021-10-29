package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username :- "+ username + " Password :- "+ password);
		
		RequestDispatcher rd = null ;
		
		if("admin".equals(username) && "admin".equals(password)) {
			
			HttpSession session = request.getSession();
 			session.setAttribute("username", username);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
			
		}
		
		else {
			
			rd= request.getRequestDispatcher("login.jsp");
			PrintWriter writer = response.getWriter();
			
			rd.include(request, response);
			
			writer.print("<center> <h2><span style='color:red'>Invalid User 	Name or Password</span></h2></center>");
			//response.sendRedirect("invalid.jsp?error=1");
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
