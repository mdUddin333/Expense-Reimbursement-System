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

@WebServlet("/status")
public class GetReimByStatus extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){
			
			
			String status=request.getParameter("status1");
			
			
			
			Reimbursement reimStatus=new Reimbursement();
			reimStatus.setType(status);
			

			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			List<Reimbursement> riemStatuses=dao.getReimbursementStatus(status);
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>...Reimbursement Status..</Title>");
			out.println("</Head>");
			out.println("<Body>");
			out.println("<h1>Reimbursement Status</h1>");
			out.println("<table border=1 width=50% height=50%>"); 
			out.println("<tr><th>Reimbursement id</th>");
			out.println("<th>User id</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Submit date</th>");
			out.println("<th>Reimbursement Type</th>");
			out.println("<th>Reimbursement Status</th></tr>");
			
			
			for(Reimbursement reimStatus1:riemStatuses) {
				
				int rmid=reimStatus1.getReimbursementId();
				int empId=reimStatus1.getEmplId();
				double amount=reimStatus1.getAmount();
				
				String submitDate=reimStatus1.getSubmitDate();
				String reimtype=reimStatus1.getType();
				String reimstatus=reimStatus1.getStatus();
						
				
			

				 out.println("<tr><td>"+rmid+"</td>");
				 out.println("<td>"+empId+"</td>");
				 out.println("<td>"+amount+"</td>");
				 out.println("<td>"+submitDate+"</td>");
				 out.println("<td>"+reimtype+"</td>");
				 out.println("<td>"+status+"</td>");

			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			
			out.println("<hr>");
			request.getRequestDispatcher("/adminNavbar.html").include(request, response);;
			out.println("<br>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
