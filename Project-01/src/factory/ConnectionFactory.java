package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection=null;
	
	private ConnectionFactory() {}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String dbDriver = "com.mysql.jdbc.Driver";
		 
		String url="jdbc:mysql://localhost:3306/project01";
        String username="root";
        String password="12345";
        
		Class.forName(dbDriver);

		connection=DriverManager.getConnection(url,username,password);
		
		return connection;
		
	}

}
