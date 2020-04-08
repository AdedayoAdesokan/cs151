import java.util.ArrayList;

public class Reservation { 
	private ArrayList<Show> shows;	
	private ArrayList<String> reservedSeats;
	private ArrayList<Integer> prices;
	public Reservation()
	{	
		shows = new ArrayList<>();
		
		String name = "Miracle on 34th Street";
		String time1 = "6:30";
		String time2 = "8:30";
		
		Show oneA = new Show(name, time1);
		shows.add(oneA);
		oneA.setDate(1);
		Show oneB = new Show(name, time2);
		shows.add(oneB);
		oneB.setDate(1);
		
		Show twoA = new Show(name, time1);
		shows.add(twoA);
		twoA.setDate(2);
		Show twoB = new Show(name, time2);
		shows.add(twoB);
		twoB.setDate(2);
		
		Show threeA = new Show(name, time1);
		shows.add(threeA);
		threeA.setDate(3);
		Show threeB = new Show(name, time2);
		shows.add(threeB);
		threeB.setDate(3);
		
		Show fourA = new Show(name, time1);
		shows.add(fourA);
		fourA.setDate(4);
		Show fourB = new Show(name, time2);
		shows.add(fourB);
		fourB.setDate(4);
		
		Show fiveA = new Show(name, time1);
		shows.add(fiveA);
		fiveA.setDate(5);
		Show fiveB = new Show(name, time2);
		shows.add(fiveB);
		fiveB.setDate(5);
		
		Show sixA = new Show(name, time1);
		shows.add(sixA);
		sixA.setDate(6);
		Show sixB = new Show(name, time2);
		shows.add(sixB);
		sixB.setDate(6);
		
		Show sevenA = new Show(name, time1);
		shows.add(sevenA);
		sevenA.setDate(7);
		Show sevenB = new Show(name, time2);
		shows.add(sevenB);
		sevenB.setDate(7);
		
		Show eightA = new Show(name, time1);
		shows.add(eightA);
		eightA.setDate(8);
		Show eightB = new Show(name, time2);
		shows.add(eightB);
		eightB.setDate(8);
		
		Show nineA = new Show(name, time1);
		shows.add(nineA);
		nineA.setDate(9);
		Show nineB = new Show(name, time2);
		shows.add(nineB);
		nineB.setDate(9);
		
		Show tenA = new Show(name, time1);
		shows.add(tenA);
		tenA.setDate(10);
		Show tenB = new Show(name, time2);
		shows.add(tenB);
		tenB.setDate(10);
		
		Show elevenA = new Show(name, time1);
		shows.add(elevenA);
		elevenA.setDate(11);
		Show elevenB = new Show(name, time2);
		shows.add(elevenB);
		elevenB.setDate(11);
		
		reservedSeats = new ArrayList<>();
		prices = new ArrayList<>();
	}
	
	public void removeShow()
	{
		for (Show show: shows)
		{
			if (show.fullSize() == 0)
			{
				shows.remove(show);
			}
		}
	}
	
	public String getShowDate(int i)
	{
		return shows.get(i-1).getDate();
	}
	
	public String getShowTime(int i)
	{
		return shows.get(i-1).getTime();
	}
	
	public Show findShow(String date, String time) 
	{
		Show temp = shows.get(0);
		for (Show show : shows)
		{
			if (date.equals(show.getDate()) && time.equals(show.getTime()))
			{
				temp = show;
			}
		}
		return temp;
	}
	
	public void reserveSeat(Show found, String section, int seat)
	{
		for (Show show : shows)
		{
			if (show == found)
			{
				show.reserveSeat(section, seat);
				String reservedSeat = "Date: " + show.getDate() + " Time: " + show.getTime() + " Section: " + section + " Seat: " + seat;
				reservedSeats.add(reservedSeat);
				if (section.equals("Main Floor"))
				{
					int price = show.getMainFloorPrice(seat);
					prices.add(price);
				}
				if (section.equals("East Balcony"))
				{
					int price = show.getEastBalconyPrice(seat);
					prices.add(price);
				}
				if (section.equals("West Balcony"))
				{
					int price = show.getWestBalconyPrice(seat);
					prices.add(price);
				}
				if (section.equals("South Balcony"))
				{
					int price = show.getSouthBalconyPrice(seat);
					prices.add(price);
				}
			}
		}
	}
	
	public boolean isAvailable(Show found, String section, int seat)
	{
		boolean availability = false;
		for (Show show : shows)
		{
			if (show == found)
			{
				availability = show.contains(section, seat);
			}
		}
		return availability;
	}
	
	public void view()
	{		
		System.out.println("Reservations:");
		for (String reservation : reservedSeats)
		{
			System.out.println(reservation);
		}
	}
	
	public void cancel(String section,int seat)
	{
		
		for (String reservation : reservedSeats)
		{
			CharSequence delete = "Seat: " + seat;
			if (reservation.contains(delete))
			{
				reservedSeats.remove(reservation);
			}
		}
		
		for (Show show : shows)
		{
			if (!show.contains(section, seat))
			{
				show.unReserveSeat(section, seat);
				if (section.equals("Main Floor"))
				{
					int price = show.getMainFloorPrice(seat);
					prices.remove(price);
				}
				if (section.equals("East Balcony"))
				{
					int price = show.getEastBalconyPrice(seat);
					prices.remove(price);
				}
				if (section.equals("West Balcony"))
				{
					int price = show.getWestBalconyPrice(seat);
					prices.remove(price);
				}
				if (section.equals("South Balcony"))
				{
					int price = show.getSouthBalconyPrice(seat);
					prices.remove(price);
				}
			}
		}
	}
	
	public int totalPrice()
	{
		int totalPrice = 0;
		for (int price : prices)
		{
			totalPrice = totalPrice + price;
		}
		return totalPrice;
	}
	
	public String getReservedSeats()
	{
		String list = "";
		for (String reservation : reservedSeats)
		{
			if (list.equals(""))
			{
				list = reservation;
			}
			else
			{
				list = list + " || " + reservation;
			}
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		Reservation only = new Reservation();
		for (int i = 1; i < 23; i++)
		{
			System.out.println(only.getShowDate(i));
			System.out.println(only.getShowTime(i));
		}
		Show test = only.findShow("January 2, 2021", "6:30");
		String section = "Main Floor";
		int seat = 10; 
		test.reserveSeat(section, seat);
		System.out.println(test.viewMainFloorAvailableSeats());
		
		
		Reservation one = new Reservation();
		Show test2 = one.findShow("January 2, 2021", "6:30");
		String section2 = "Main Floor";
		int seat2 = 10; 
		int seat3 = 11;
		one.reserveSeat(test2, section2, seat2);
		one.reserveSeat(test2, section2, seat3);
		System.out.println(one.findShow("January 2, 2021", "6:30").viewMainFloorAvailableSeats());
		one.view();
		System.out.println(one.getReservedSeats());
	}
}
