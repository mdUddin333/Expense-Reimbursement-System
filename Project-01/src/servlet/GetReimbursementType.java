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

@WebServlet("/type")
public class GetReimbursementType extends HttpServlet{
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){
			
			
			String type=request.getParameter("type1");
			
			
			
			Reimbursement reimType=new Reimbursement();
			reimType.setType(type);
			

			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			List<Reimbursement> riemTypes=dao.getReimbursementType(type);
			
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>...Reimbursement Type..</Title>");
			out.println("</Head>");
			out.println("<Body>");
			out.println("<h1>Reimbursement Type</h1>");
			out.println("<table border=1 width=50% height=50%>"); 
			out.println("<tr><th>Reimbursement id</th>");
			out.println("<th>User id</th>");
			out.println("<th>Amount</th>");
			out.println("<th>Submit date</th>");
			out.println("<th>Reimbursement Type</th>");
			out.println("<th>Reimbursement Status</th></tr>");
			
			
			for(Reimbursement reimType1:riemTypes) {
				
				int rmid=reimType1.getReimbursementId();
				int empId=reimType1.getEmplId();
				double amount=reimType1.getAmount();
				
				String submitDate=reimType1.getSubmitDate();
				String reimtype=reimType1.getType();
				String status=reimType1.getStatus();
						
				
			

				 out.println("<tr><td>"+rmid+"</td>");
				 out.println("<td>"+empId+"</td>");
				 out.println("<td>"+amount+"</td>");
				 out.println("<td>"+submitDate+"</td>");
				 out.println("<td>"+type+"</td>");
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
	

