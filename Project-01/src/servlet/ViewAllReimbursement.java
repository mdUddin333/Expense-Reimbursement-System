package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.md.Reimbursement;

import dao.ReimbursementDao;
import factory.ReimbursementDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ViewAllReimbursement extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){

			
			request.getRequestDispatcher("/adminNavbar.html").include(request, response);;
			out.println("<br>");
			out.println("<hr>");

			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			List<Reimbursement> riems=dao.getAllReimbursement();
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>...Reimbursement..</Title>");
			out.println("</Head>");
			out.println("<Body style='background-color:#09ba91'>");
			out.println("<h1>Here is Your Reimbursement List</h1>");
			out.println("<table border=1 width=50% height=50%>"); 
			out.println("<tr><th>Reimbursement id</th>");
			out.println("<th>User id</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Submit date</th>");
			out.println("<th>Reimbursement Type</th>");
			out.println("<th>Reimbursement Status</th></tr>");
			
			
			for(Reimbursement reim:riems) {
				int reimId=reim.getReimbursementId();
				int userId=reim.getEmplId();
				double amount=reim.getAmount();
				String submitDate=reim.getSubmitDate();
				String type=reim.getType();
				String status=reim.getStatus();

				 out.println("<tr><td>"+reimId+"</td>");
				 out.println("<td>"+userId+"</td>");
				 out.println("<td>"+amount+"</td>");
				 out.println("<td>"+submitDate+"</td>");
				 out.println("<td>"+type+"</td>");
				 out.println("<td>"+status+"</td>");

			}
			
			out.println("</table>");
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
