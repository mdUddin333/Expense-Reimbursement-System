package dao;

import java.sql.SQLException;
import java.util.List;

import com.md.Reimbursement;
import com.md.User;

public interface ReimbursementDao {

	void addReimbursement(Reimbursement reim) throws SQLException;
	
	void updateReimbursement(Reimbursement reim) throws SQLException;

	List<Reimbursement> getAllReimbursement() throws SQLException;

	
	List<Reimbursement> getReimbursementByUserId(int userId) throws SQLException;

	List<Reimbursement> getReimbursementType(String type) throws SQLException;

	List<Reimbursement> getReimbursementStatus(String status) throws SQLException;

	void changeReimbursementStatus(Reimbursement reim) throws SQLException;
	
}
