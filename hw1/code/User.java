public class User {
	private String password;
	private String id;
	
	public User(String id, String password)
	{
		this.password = password;
		this.id = id;
	}
	
	public 	String getPassword()
	{
		return password;
	}
	
	public String getId()
	{
		return id;
	}
	
	public boolean authenticate(String password)
	{
		if (this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}