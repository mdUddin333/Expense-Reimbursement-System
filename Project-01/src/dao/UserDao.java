package dao;

import java.sql.SQLException;
import java.util.List;

import com.md.User;

public interface UserDao {
	
	void addEmployee(User user) throws SQLException;
	
	void updateEmployee(User user) throws SQLException;

	void deleteEmployee(int id) throws SQLException;

	List<User> getAllEmployee() throws SQLException;
	
	public boolean userLogin(String username,String password)throws SQLException;

}
