package controller;

import java.util.List;
import model.Message;

public interface MessageDAO {
	
	public List<Message> getAllMessages();
	public boolean addMessage(Message user, int userId);
}
