package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.md.User;

import dao.UserDao;
import factory.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewAllEmployees extends HttpServlet{


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
		
			try(PrintWriter out=response.getWriter()){
			
			request.getRequestDispatcher("/navbar.html").include(request, response);;
			out.println("<br>");
			
			
			UserDao dao=UserDaoFactory.getUserDao();
			List<User> employees=dao.getAllEmployee();
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Employee List</Title>");
			out.println("</Head>");
			out.println("<Body style='background-color:#eaf2d8'>");
			out.println("<h1>Employee List</h1>");
			out.println("<table class='display-4 p-3 mb-2 bg-info text-dark' border=1 width=50% height=50%>"); 
			out.println("<tr><th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Username</th>");
			out.println("<th>Password</th>");
			out.println("<th>Actions</th></tr>");
			
						
			 for(User employee:employees) {
				 
				 int id=employee.getUserId();
				 String name=employee.getName();
				 String email=employee.getEmail();
				 String username=employee.getUsername();
				 String password=employee.getPassword();

				 
				 out.println("<tr><td>"+id+"</td>");
				 out.println("<td>"+name+"</td>");
				 out.println("<td>"+email+"</td>");
				 out.println("<td>"+username+"</td>");
				 out.println("<td>"+password+"</td>");
				 
				 
					//out.println("<h1><a href='ServletUrlRewriting2?name="+name+"'>Click me</a></h1>");
				//out.println("<td><a href='updateEmployee.html?id=<c:out value='${employee.}'"+id+"'>edit</a></td>");
				 /* <td>
                 <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="delete?id=<c:out value='${user.id}' />">Delete</a>                     
                </td>
                */
				
				 out.println("<td><a href='updateEmployee.html?id="+id+"'>edit</a></td>"+
                "<td><a href='deleteEmployee.html?id="+id+"'>delete</a></td></tr>");

				 
				 //out.println("<td><a href='update?id' value='${}'>edit</a></td>");
				 
				 
			 }
			 
			 
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");


			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
	
}
