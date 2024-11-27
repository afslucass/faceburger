package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.ConnectionBD;
import model.Message;
import java.sql.PreparedStatement;

public class MessageActions implements MessageDAO {
	
	private Connection conn;
	
	public MessageActions() throws SQLException
	{
		conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
	}

	@Override
	public List<Message> getAllMessages() {
		return null;
	}

	@Override
	public boolean addMessage(Message user) {
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO LOGIN (userLogin,senhaLogin,perfilUser) "+
											"VALUES (?,?,?)");
			ps.setString(1, user.getNick());
			ps.setString(2, user.getMessage());
			ps.setString(3, user.getCreatedAt());
			
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
