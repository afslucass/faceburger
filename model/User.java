package model;

public class User {
	
	
	private int id;
	private String nick;
	
	public User(String nick)
	{
			this.id = 0;
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
