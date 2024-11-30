package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import config.ConnectionBD;
import model.Message;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserActions implements UserDAO{
	
	private Connection conn;
	
	public UserActions() throws SQLException
	{
		conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
	}

	@Override
	public User adicionaUser(User user) {
		User currentUser = new User();

		try {
			currentUser.setNick(user.getNick());

			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO usuario (nome_usuario) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNick());
			
			int affectedRows = ps.executeUpdate();

			if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
				generatedKeys.next();
				int generatedId = generatedKeys.getInt(1);
				currentUser.setId(generatedId);
			}   

			ps.close();
			
		} catch (Exception e) {
			
		}
		
		return currentUser;
	}
}
