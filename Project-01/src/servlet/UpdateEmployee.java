package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.md.User;

import dao.UserDao;
import factory.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class UpdateEmployee extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		try(PrintWriter out=response.getWriter()){
			
			request.getRequestDispatcher("/navbar.html").include(request, response);;
			out.println("<br>");
			
			int id=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			
			User employee=new User();
			
			employee.setUserId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setUsername(username);
			employee.setPassword(password);
			
			UserDao dao=UserDaoFactory.getUserDao();
			dao.updateEmployee(employee);
			
			out.println("Employee have successfully Updated");
			out.println("<br>");
			
			out.println("<h1>Employee Id: "+id+", Name: "+name+", Email: "+email+", Username: "+username+", Password:"+password+"</h1>");
			//out.println(employee);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
