package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.md.Reimbursement;
import com.md.User;

import dao.ReimbursementDao;
import dao.UserDao;
import factory.ReimbursementDaoFactory;
import factory.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changeStatus")
public class ChangeReimStatus extends HttpServlet{
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		try(PrintWriter out=response.getWriter()){
			
			request.getRequestDispatcher("/adminNavbar.html").include(request, response);;
			out.println("<br>");
			
			int reimId=Integer.valueOf(request.getParameter("ReimbursementId"));
			String status=request.getParameter("changeStatus");
			
			Reimbursement reim=new Reimbursement();
			
			reim.setReimbursementId(reimId);
			reim.setStatus(status);
			
			
			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			dao.changeReimbursementStatus(reim);
			
			out.println("Reimbursement status have successfully Updated");
			out.println("<br>");
			
			out.println("<h1>Reimbursement Id: "+reimId+", Status: "+status+"</h1>");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
