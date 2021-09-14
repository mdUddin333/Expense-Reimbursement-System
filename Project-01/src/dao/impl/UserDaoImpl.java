package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.md.User;

import dao.UserDao;
import factory.ConnectionFactory;

public class UserDaoImpl implements UserDao{
	
	Connection connection=null;
    private static Statement statement = null;
    
	public  UserDaoImpl() throws ClassNotFoundException, SQLException {
		this.connection=ConnectionFactory.getConnection();
	}
	

	@Override
	public void addEmployee(User user) throws SQLException {
	
		String sql="insert into employee(name,email,username,password) values(?,?,?,?)";
	
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getPassword());
		
		int count=ps.executeUpdate();
		
		if (count>0) {
			System.out.println("Employee added");
		}else {
			System.out.println("Something went wrong");
		}
	}
	
	@Override
	public void updateEmployee(User user) throws SQLException {
		
		String sql="update employee set name=?,email=?,username=?,password=? where empl_id=?";
	
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getPassword());
		ps.setInt(5, user.getUserId());

		int count=ps.executeUpdate();
		
		if (count>0) {
			System.out.println("Employee Updated");
		}else {
			System.out.println("Something wemt wrong!!!");
		}
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		
		String sql="delete from employee where empl_id=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1, id);
		int count=ps.executeUpdate();
		
		if (count>0) {
			System.out.println("Employee deleted");
		}else {
			System.out.println("Something wemt wrong!!!");
		
		}
		
	}

	@Override
	public List<User> getAllEmployee() throws SQLException {
		
		List<User> employees=new ArrayList();
		
		String sql="select * from employee";
		
		 statement = connection.createStatement();
	     ResultSet rs = statement.executeQuery(sql);
			
	     while (rs.next()) {
			
	    User employee=new User();
	    employee.setUserId(rs.getInt(1));
	    employee.setName(rs.getString(2));
	    employee.setEmail(rs.getString(3));
	    employee.setUsername(rs.getString(4));
	    employee.setPassword(rs.getString(5));

	    employees.add(employee);
	    
	    
		}
		
		return employees;
	}


	@Override
	public boolean userLogin(String username, String password) throws SQLException {

		String sql="select username,password from employee where username=? and password=?";
		
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
