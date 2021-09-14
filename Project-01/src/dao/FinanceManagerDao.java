package dao;

import java.sql.SQLException;
import java.util.List;

import com.md.User;

public interface FinanceManagerDao {

	
	
	public boolean adminLogin(String username,String password)throws SQLException;

	
}
