import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TheaterSystem {
	public static void main(String[] args) {
		Reservation reservations = new Reservation();
		File allReservations = new File("C:\\Users\\Dayo's XPS\\Documents\\CS151\\hw1\\reservations.txt");
		Scanner in = new Scanner(System.in);
		System.out.println("Sign [U]p   Sign [I]n   E[X]it");
		String input = in.next();
		UserManagement uManagement = new UserManagement();
		
		if (input.toUpperCase().equals("U")) {
			System.out.println("Please enter id");
			String id = in.next();
			System.out.println("Please enter password");
			String password = in.next();
			User newUser = new User(id, password);
			uManagement.addUser(newUser);
			System.out.println("Sign [U]p   Sign [I]n   E[X]it");
			input = in.next();
		}
		if (input.toUpperCase().equals("I")) {
			System.out.println("Please enter id");
			String id = in.next();
			System.out.println("Please enter password");
			String password = in.next();
			User existingUser = uManagement.find(id);
			if (existingUser == null) {
				System.out.println("Error: id not found. Please try again or sign up if new");
				System.out.println("Sign [U]p   Sign [I]n   E[X]it");
				input = in.next();
			} else if (existingUser.authenticate(password) == false) {
				System.out.println("Error: invalid password,Please try again or sign up if new");
				System.out.println("Sign [U]p   Sign [I]n   E[X]it");
				input = in.next();
				
			} else {
				// boolean transaction = false;
				// while (!transaction) {
				System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
				String input2 = in.next();

				if (input2.toUpperCase().equals("R")) {
					System.out.println("Please enter date of desired show ");
					String date = in.next();
					System.out.println("Please enter time of desired show ");
					String time = in.next();

					System.out.println("Available Seats:");
					System.out
							.println(" Main Floor:" + reservations.findShow(date, time).viewMainFloorAvailableSeats());
					System.out.println(
							" East Balcony:" + reservations.findShow(date, time).viewEastBalconyAvailableSeats());
					System.out.println(
							" West Balcony:" + reservations.findShow(date, time).viewWestBalconyAvailableSeats());
					System.out.println(
							" South Balcony:" + reservations.findShow(date, time).viewSouthBalconyAvailableSeats());

					System.out.println("Please enter desired section (ex: Main Floor)");
					String section = in.next();
					System.out.println("Please enter desired seat (ex: 22)");
					String seatString = in.next();
					int seat = Integer.parseInt(seatString);
					if (reservations.isAvailable(reservations.findShow(date, time), section, seat)) {
						reservations.reserveSeat(reservations.findShow(date, time), section, seat);

					} else {
						System.out.println("Seat not available");
					}

					System.out.println("Would you like to make another reservation for this show");
					String answer1 = in.next();
					if (answer1.toLowerCase().equals("yes")) {
						System.out.println("Please enter desired section (ex: Main Floor)");
						section = in.next();
						System.out.println("Please enter desired seat (ex: 22)");
						seatString = in.next();
						seat = Integer.parseInt(seatString);
						if (reservations.isAvailable(reservations.findShow(date, time), section, seat)) {
							reservations.reserveSeat(reservations.findShow(date, time), section, seat);

						} else {
							System.out.println("Seat not available");
						}
						
						//THIS IS WHERE WE INSERT MORE IF STATEMENTS TO RESERVE MORE SEATS*******************************************************************
						
					} else {
						System.out.println("Do you want to make another [r]eservation or [c]onfirm the reservation?");
						String confirmation = in.next();
						if (confirmation.toLowerCase().equals("c")) {
							System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
							input2 = in.next();
						}
						else
						{
							//////////////////THIS IS WHERE WE COPY RESERVATION AGAIN*************************************************************************************
						}
					}
				}

				if (input2.toUpperCase().equals("V")) {
					reservations.view();
					System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
					input2 = in.next();
				}

				if (input2.toUpperCase().equals("C")) {
					reservations.view();
					System.out.println("Please enter desired section");
					String deleteSection = in.next();
					System.out.println("Please enter desired seat");
					String deleteSeat = in.next();
					int deleteSeatNumber = Integer.parseInt(deleteSeat);
					reservations.cancel(deleteSection, deleteSeatNumber);
					
					//This is where we ask if they want to delete more seats********************
				}

				if (input2.toUpperCase().equals("O")) {
					Random rng = new Random();
					int confirmationNumber = rng.nextInt(9000) + 1000;
					System.out.println("Confirmation number: " +confirmationNumber);
					reservations.view();
					System.out.println("Total price: " + reservations.totalPrice());
					System.out.println("Sign [U]p   Sign [I]n   E[X]it");
					//This is where we get the different inputs going
				}
			}
		}
		if (input.toUpperCase().equals("X")) {
			try {
				FileWriter myWriter = new FileWriter("reservations.txt");
				myWriter.write(reservations.getReservedSeats());
				myWriter.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
