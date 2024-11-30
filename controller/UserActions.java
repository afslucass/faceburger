package controller;

import java.sql.Connection;
import java.sql.SQLException;
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
					conn.prepareStatement("INSERT INTO usuario (nome_usuario) VALUES (?)");
			ps.setString(1, user.getNick());
			
			ps.executeUpdate();
			ps.close();

			String sql = "select id_usuario from usuario where nome_usuario="+user.getNick();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				currentUser.setId(rs.getInt("id_usuario"));
			}

			stmt.close();
			
			
		} catch (Exception e) {
			
		}
		
		return currentUser;
	}
}
