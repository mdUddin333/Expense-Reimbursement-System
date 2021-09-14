package factory;

import java.sql.SQLException;

import dao.FinanceManagerDao;
import dao.UserDao;
import dao.impl.FinanceManagerDaoImpl;
import dao.impl.UserDaoImpl;

public class FinanceManagerDaoFactory {

	
	private static FinanceManagerDao dao;
	private FinanceManagerDaoFactory() {}
	
	public static FinanceManagerDao getUserDao() throws ClassNotFoundException, SQLException {
		if (dao == null) {
			dao=new FinanceManagerDaoImpl();
		}
		
		return dao;
		
	}
	
	
}
