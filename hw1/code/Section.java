import java.util.ArrayList;

public class Section {
	private String name;
	private int totalSeats;
	private ArrayList<Integer> seats; 
	
	public Section(String name, int totalSeats)
	{
		this.name = name;
		this.totalSeats = totalSeats;
		seats = new ArrayList<>();
		for (int i = 1; i <= totalSeats; i++)
		{
			seats.add(i);
		}
	}
	
	public String getSection()
	{
		return this.name;
	}
	
	public void removeSeat(Integer seat)
	{
		if (seats.contains(seat))
		{
			seats.remove(seat);
		}
	}
	
	public void addSeat(Integer seat)
	{
		if(!seats.contains(seat))
		{
			seats.add(seat);
		}
	}
	
	public int getSeatIndex(Integer seat)
	{
		return seats.indexOf(seat);
	}
	
	public String toString()
	{
		return seats.toString();
	}
	
	public int size()
	{
		return seats.size();
	}
	
	public boolean contains(int i)
	{
		return seats.contains(i);
	}
	
	public static void main(String[] args)
	{
		String name = "MainFloor";
		int seats = 150;
		Section mF = new Section(name, seats);
		System.out.println(mF.toString());
		
		mF.removeSeat(10);
		System.out.println(mF.toString());
		
		System.out.println(mF.getSeatIndex(10));
	}
}
