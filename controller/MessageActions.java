package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import config.ConnectionBD;
import model.Message;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MessageActions implements MessageDAO {
	
	private Connection conn;
	
	public MessageActions() throws SQLException
	{
		conn = ConnectionBD.getConnection();
		System.out.println("Conexão Aberta!");
		
	}

	@Override
	public ArrayList<Message> getAllMessages() {
		ArrayList<Message> lista = new ArrayList<>();

        String sql = "select nome_usuario, mensagem from usuario inner join mensagem on FK_ID_USUARIO = id_usuario order by id_mensagem desc;";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Message message = new Message();

                message.setMessage(rs.getString("mensagem"));
				message.setNick(rs.getString("nome_usuario"));

                lista.add(message);
            }

            stmt.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        
        }
        
        return lista;
	}

	@Override
	public boolean addMessage(Message message, int userId) {
		
		try {
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO mensagem (MENSAGEM, FK_ID_USUARIO) VALUES (?, ?)");				
			ps.setString(1, message.getMessage());
			ps.setInt(2, userId);
			
			ps.executeUpdate();
			ps.close();
			return true;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
