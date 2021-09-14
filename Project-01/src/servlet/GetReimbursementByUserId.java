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

@WebServlet("/getReimbursementByUserId")
public class GetReimbursementByUserId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){
			

			
			int userId=Integer.valueOf(request.getParameter("id"));
			
			
			
			Reimbursement reim=new Reimbursement();
			reim.setEmplId(userId);
			

			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			List<Reimbursement> riems=dao.getReimbursementByUserId(userId);
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>...Reimbursement..</Title>");
			out.println("</Head>");
			out.println("<Body>");
			out.println("<h1>Reimbursement</h1>");
			out.println("<table border=1 width=50% height=50%>"); 
			out.println("<tr><th>Reimbursement id</th>");
			out.println("<th>User id</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Submit date</th>");
			out.println("<th>Reimbursement Type</th>");
			out.println("<th>Reimbursement Status</th></tr>");
			
			
			for(Reimbursement reim2:riems) {
				int reimId=reim2.getReimbursementId();
				int userId2=reim2.getEmplId();
				double amount=reim2.getAmount();
				String submitDate=reim2.getSubmitDate();
				String type=reim2.getType();
				String status=reim2.getStatus();

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
			
			
			out.println("<hr>");
			request.getRequestDispatcher("/employeeNavbar.html").include(request, response);

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
