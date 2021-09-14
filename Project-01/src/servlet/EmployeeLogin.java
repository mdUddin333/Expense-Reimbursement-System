package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.md.User;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employeeLogin")
public class EmployeeLogin extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User employee=new User();	
		
		response.setContentType("text/html");
		
		try(PrintWriter out =response.getWriter()){
			
			//request.getRequestDispatcher("/navbar.html").include(request, response);;
			//out.println("<br>");
			
			UserDao dao=new UserDaoImpl();

			String username= request.getParameter("username");
			String password=request.getParameter("password");
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet state managment</title>");
			out.println("</head>");
			out.println("<body style='background-color:#eaf2d8'>");
			
			request.getRequestDispatcher("/navbar.html").include(request, response);;

			
			if (dao.userLogin(username, password)&& dao.userLogin(username, password)) {
				System.out.println("successfully login");
				
				out.println("<h4>You're logged in</h4>");
				out.println("<h2>Welcome to Revature's Expenses Reimbursement System</h2>");

				out.println("<h1></br>Welcome, "+username +" !!!!</h1>");
				
				
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
			 	
				// here all the request for the customer
				//out.println("<div class='container'><h1><a href='profile.html'>Profile</a></h1></div>");
				out.println("<div><h1><a href='employeeNavbar.html'>Profile</a></h1></div>");
				
				
				//response.sendRedirect("navbar.html");
				//request.getRequestDispatcher("/index.html").include(request, response);;
				out.println("<h1><a href='employeeLogin.html'>Logout</a></h1>");

			
			}else {
				
				out.println("Wrong username and password...\n Please Try again here");
				RequestDispatcher rd=request.getRequestDispatcher("/employeeLogin.html");
				rd.include(request, response);
			
			}
			//request.getRequestDispatcher("/navbar.html").include(request, response);;

			//response.sendRedirect("navbar.html");

			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
