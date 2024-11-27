package config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBD {
	
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/faceburger";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
			
		}catch(SQLException | ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		} 
		
	}

}
