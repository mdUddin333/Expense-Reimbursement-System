package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FinanceManagerDao;
import factory.ConnectionFactory;

public class FinanceManagerDaoImpl implements FinanceManagerDao{

	Connection connection=null;
    
	public  FinanceManagerDaoImpl() throws ClassNotFoundException, SQLException {
		this.connection=ConnectionFactory.getConnection();
	}
	

	@Override
	public boolean adminLogin(String username, String password) throws SQLException {
		String sql="select username,password from admin where username=? and password=?";
		
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs=ps.executeQuery();
        
        while (rs.next()) {
        	
			rs.getString("username");
			rs.getString("password");
			
			return true;

		}		
        return false;
	}

}
