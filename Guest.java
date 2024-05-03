import java.util.*;

public class Guest extends User implements GuestInterface {
	private ArrayList<Room> room_list_for_guest = new ArrayList<>();

	public ArrayList<Room> getRoom_list_for_guest() {
		return room_list_for_guest;
	}

	public void setRoom_list_for_guest(ArrayList<Room> room_list_for_guest) {
		this.room_list_for_guest = room_list_for_guest;
	}

	// default constructor
	public Guest() {
		super();
	}
	

	// constructor that takes parameters
	public Guest(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	// allow the guest to view the information of all rooms
	@Override
	public void viewAllRooms(ArrayList<Room> rooms) {
		int i = 0;
		while(i < rooms.size()) {
			Room room = rooms.get(i);
			System.out.println("Room type: " + room.getType() + ", Id: " + room.getId() + 
					", Capacity: " + room.getCapacity() + ", Price: " + room.getPrice());
			i++;
		}
	}
	
	// check if the guest wants to book a room
	public boolean ifBook() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Do you want to book a room? Enter Yes or No: ");
	    String response = scanner.nextLine();
	    return "Yes".equalsIgnoreCase(response);
	}
	
	// check if the guest wants to check out
	public boolean ifLeave() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Do you want to check out? Enter Yes or No: ");
	    String response = scanner.nextLine();
	    return "Yes".equalsIgnoreCase(response);
	}
	
	// return guest's info in String format
	public String toString() {
		return this.getFirstName() + ", " + this.getLastName();
	}
}
