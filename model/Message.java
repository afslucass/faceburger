package model;

public class Message {
	
	
	private String nick;
	private String createdAt;
	private String message;
	
	public Message(String nick, String createdAt, String message)
	{
			this.nick = nick;
			this.createdAt = createdAt;
			this.message = message;
	}
	
	public Message()
	{
		this(null, null, null);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
