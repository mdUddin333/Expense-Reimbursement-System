package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import com.md.Reimbursement;

import dao.ReimbursementDao;
import factory.ReimbursementDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reimbursementReq")
public class ReimbursementRequest extends HttpServlet{


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter out=response.getWriter()){
			
			int id=Integer.valueOf(request.getParameter("id"));
			double amount=Double.valueOf(request.getParameter("amount"));
			String submitDate=request.getParameter("submitDate");
			String ReimbursementType=request.getParameter("type1");
			String ReimbursementStatus=request.getParameter("status1");
			
			Reimbursement reim=new Reimbursement();
			
			reim.setEmplId(id);
			reim.setAmount(amount);
			reim.setSubmitDate(submitDate);
			reim.setType(ReimbursementType);
			reim.setStatus(ReimbursementStatus);
			
			ReimbursementDao dao=ReimbursementDaoFactory.getReimbursementDao();
			
			dao.addReimbursement(reim);
			out.println("Your Reimbursement added");
			
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
