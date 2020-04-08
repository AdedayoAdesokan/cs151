import java.util.ArrayList;

public class Show {
	private String date;
	private String time;
	private String name;
	private ArrayList<String> dates;
	private final int RUNTIME = 11;  //number of days the show is in theaters
	private String showDate;
	
	private Section mainFloor;
	private Section eastBalcony;
	private Section westBalcony;
	private Section southBalcony;
	private int price;
	
	public Show(String name, String time)
	{
		date = "";
		this.time = time;
		dates = new ArrayList<>();
		this.name = name;
		int count = 23;  //the first day the show will be aired
		for (int i = 0; i < RUNTIME; i++)
		{
			if (count < 31 && count > 22)
			{
				date = "December " + count + ", 2020";
				dates.add(date);
				count++;
			}
			else if (count == 31)
			{
				date = "December " + count + ", 2020";
				dates.add(date);
				count = 1;
			}
			else
			{
				date = "January " + count + ", 2021";
				dates.add(date);
				count++;
			}
		}
		
		String name1 = "Main Floor";
		String name2 = "East Balcony";
		String name3 ="West Balcony";
		String name4 ="South Balcony";
		int seat1 = 150;
		int seat2 = 100;
		int seat3 = 50;
		mainFloor = new Section(name1, seat1);
		eastBalcony = new Section(name2, seat2);
		westBalcony = new Section(name3, seat2);
		southBalcony = new Section(name4, seat3);
		String showDate = "";
	}
	
	public String toString()
	{
		return dates.toString();
	}
	
	public String getTime()
	{
		return time;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String viewMainFloorAvailableSeats()
	{
		return mainFloor.toString();
	}
	public String viewEastBalconyAvailableSeats()
	{
		return eastBalcony.toString();
	}
	public String viewWestBalconyAvailableSeats()
	{
		return westBalcony.toString();
	}
	public String viewSouthBalconyAvailableSeats()
	{
		return southBalcony.toString();
	}
	
	public void reserveSeat(String section, Integer i)
	{
		if (section.equals(mainFloor.getSection()))
		{
			mainFloor.removeSeat(i);
		}
		if (section.equals(eastBalcony.getSection()))
		{
			eastBalcony.removeSeat(i);
		}
		if (section.equals(westBalcony.getSection()))
		{
			westBalcony.removeSeat(i);
		}
		if (section.equals(southBalcony.getSection()))
		{
			southBalcony.removeSeat(i);
		}
	}
	
	public void unReserveSeat(String section, Integer i)
	{
		if (section.equals(mainFloor.getSection()))
		{
			mainFloor.addSeat(i);;
		}
		if (section.equals(eastBalcony.getSection()))
		{
			eastBalcony.addSeat(i);
		}
		if (section.equals(westBalcony.getSection()))
		{
			westBalcony.addSeat(i);
		}
		if (section.equals(southBalcony.getSection()))
		{
			southBalcony.addSeat(i);
		}
	}
	
	public int getMainFloorPrice(Integer i)
	{
		if (i < 100)
		{
			price = 35;
		}
		else		
		{
			price = 45;
		}
		return price;
	}
	
	public int getEastBalconyPrice(Integer i)
	{
		price = 40;
		return price;
	}
	
	public int getWestBalconyPrice(Integer i)
	{
		price = 40;
		return price;
	}
	
	public int getSouthBalconyPrice(Integer i)
	{
		if (i < 25)
		{
			price = 50;
		}
		else
		{
			price = 55;
		}
		return price;
	}
	
	public int fullSize()
	{
		int size = 0;
		size = mainFloor.size() + eastBalcony.size() + westBalcony.size() + southBalcony.size();
		return size;
	}
	
	public int mainFloorSize()
	{
		int size = 0;
		size = mainFloor.size();
		return size;
	}
	
	public int eastBalconySize() 
	{
		int size = 0;
		size = eastBalcony.size();
		return size;
	}
	
	public int westBalconySize()
	{
		int size = 0;
		size = westBalcony.size();
		return size;
	}
	
	public int southBalconySize()
	{
		int size = 0;
		size = southBalcony.size();
		return size;
	}
	
	public void setDate(int i)
	{
		if (i > 0 && i < 12)
		{
			showDate = dates.get(i-1);
		}
	}
	
	public String getDate()
	{
		return showDate;
	}
	
	public boolean contains(String section, int seat)
	{
		if (section.equals(mainFloor.getSection()))
		{
			return mainFloor.contains(seat);
		}
		if (section.equals(eastBalcony.getSection()))
		{
			return eastBalcony.contains(seat);
		}
		if (section.equals(westBalcony.getSection()))
		{
			return westBalcony.contains(seat);
		}
		else
		{
			return southBalcony.contains(seat);
		}
	}
	
	public static void main(String[] args)
	{
		String time = "6:30";
		String name = "Miracle on 34th Street";
		Show m = new Show(name, time);
		
		System.out.println(m.viewMainFloorAvailableSeats());
		System.out.println(m.mainFloorSize());
		for (int i = 1; i < 151; i++)
		{
			m.reserveSeat("Main Floor", i);
		}
		System.out.println(m.mainFloorSize());
		for (int i = 1; i < 12; i++)
		{
			m.setDate(i);
			System.out.println(m.getDate());
		}
		for (int i = 1; i < 101; i++)
		{
			m.reserveSeat("East Balcony", i);
			m.reserveSeat("West Balcony", i);
		}
		for (int i = 0; i < 51; i++)
		{
			m.reserveSeat("South Balcony", i);
		}
		System.out.println(m.eastBalconySize());
		System.out.println(m.westBalconySize());
		System.out.println(m.southBalconySize());
		System.out.println("full size = " + m.fullSize());
	}
}
