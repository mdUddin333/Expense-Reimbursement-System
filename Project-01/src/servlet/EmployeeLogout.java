package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/logout")
public class EmployeeLogout extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		try(PrintWriter out=response.getWriter()){
			
			request.getRequestDispatcher("navbar.html").include(request, response);
			out.println("<br>");

			HttpSession session=request.getSession(false);
			
			if (session != null) {
				
				String username= (String) session.getAttribute("username");
					if (!username.equals("")|| username!=null) {
					
					out.println("<h1>Welcome to profile</h1>");
					out.println("<h1>Welcome, "+username+" </h1>");
						
				}
	            RequestDispatcher dispatcher=request.getRequestDispatcher("employeelogin.html");
				dispatcher.forward(request, response);
			}
			
			out.println("You're successfully logged out !!");
			
			
		}
		
		
		
	}
	
	
}
