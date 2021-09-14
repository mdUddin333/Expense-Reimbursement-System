package factory;

import java.sql.SQLException;

import dao.ReimbursementDao;
import dao.UserDao;
import dao.impl.ReimbursementDaoImpl;
import dao.impl.UserDaoImpl;

public class ReimbursementDaoFactory {

	private static ReimbursementDao dao;
	private ReimbursementDaoFactory() {}
	
	public static ReimbursementDao getReimbursementDao() throws ClassNotFoundException, SQLException {
		if (dao == null) {
			dao=new ReimbursementDaoImpl();
		}
		
		return dao;
		
	}
	
}
