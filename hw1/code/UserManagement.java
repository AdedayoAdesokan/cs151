import java.util.ArrayList;

public class UserManagement {
	private ArrayList<User> list;
	
	public UserManagement()
	{
		list = new ArrayList<User>();
	}
	
	public void addUser(User user)
	{
		if (!list.contains(user))
		{
			list.add(user);
		}
	}
	
	public User find(String username)
	{
		User clone = null;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getId().equals(username))
			{
				clone = list.get(i);
			}
		}
		return clone;
	}
	
	public String viewList()
	{
		String full = "";
		for(int i = 0; i < list.size(); i++)
		{
			String userName = list.get(i).getId();
			if (i == 0)
			{
				full = userName;
			}
			else
			{
				full = full + ", " + userName;
			}
		}
		return full;
	}
	
	
	public static void main(String[] args)
	{
		UserManagement list = new UserManagement();
		String username = "tommy1";
		String password = "12345";
		User tom = new User(username, password);
		list.addUser(tom);
		System.out.println(list.viewList());
		
		String username2 = "BigTommyT";
		String password2 = "12345";
		User tomm = new User(username2, password2);
		list.addUser(tomm);
		System.out.println(list.viewList());
		
		String username3 = "zachh";
		String password3 = ("bigzachhy");
		User zach = new User(username3, password3);
		list.addUser(zach);
		User notZach = list.find(username3);
		System.out.println(notZach.getId());
	}
}
