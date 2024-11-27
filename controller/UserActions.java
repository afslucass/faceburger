package controller;

import java.sql.Connection;
import java.sql.SQLException;

import config.ConnectionBD;
import model.User;
import java.sql.PreparedStatement;

public class UserActions implements UserDAO{
	
	private Connection conn;
	
	public UserActions() throws SQLException
	{
		conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
	}

	@Override
	public boolean adicionaUser(User user) {
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO LOGIN (userLogin) "+
											"VALUES (?)");
			ps.setString(1, user.getNick());
			
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
