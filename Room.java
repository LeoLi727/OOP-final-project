import java.util.*;

public class Room {
	
	// Attributes of Room object
	private String type;
	private String roomNumber;
	private int capacity;
	private int curGuestNum;
	private final ArrayList<Guest> guests_of_a_room = new ArrayList<>();
	private double price;
	private boolean booked = false;



	// default constructor
	public Room() {
		this.type = "xxx";
		this.roomNumber = "xxx";
		this.capacity = -1;
		this.curGuestNum = 0;
		this.price = 0;
	}

	// constructor with parameters
	public Room(String type, String roomNumber, int capacity, double price) {
		this.type = type;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.curGuestNum = 0;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurGuestNum() {
		return curGuestNum;
	}

	public void setCurGuestNum(int curGuestNum) {
		this.curGuestNum = curGuestNum;
	}

	public ArrayList<Guest> getGuests_of_a_room() {
		return guests_of_a_room;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public void displayRoomDetails() {
		System.out.println("Room Type: " + this.type);
		System.out.println("Room Number: " + this.roomNumber);
		System.out.println("Capacity: " + this.capacity);
		System.out.println("Current Number of Guests: " + this.curGuestNum);
		System.out.println("Price: " + this.price);
		System.out.println("Guests in Room:");
		for (Guest guest : guests_of_a_room) {
			System.out.println("  - Guest Name: " + guest.getFirstName() + " " + guest.getLastName() );
		}
	}



}
