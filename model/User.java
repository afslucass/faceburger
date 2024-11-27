package model;

public class User {
	
	
	private String nick;
	
	public User(String nick)
	{
			this.nick = nick;
	}
	
	public User()
	{
		this(null);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
}
