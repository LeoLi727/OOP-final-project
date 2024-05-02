import java.io.*;
import java.util.*;

public class Room implements Comparable<Room>{
	
	// Attributes of Room object
	private String type;
	private String id;
	private final int capacity = 1;
	private int curGuestNum;
	private ArrayList<Guest> guests = new ArrayList<>();
	private double price;
	
	// default constructor
	public Room() {
		
	}
	
	// constructor with parameters
	public Room(String type, String id, int curGuestNum, double price) {
		this.type = type;
		this.id = id;
		this.curGuestNum = curGuestNum;
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return the curGuestNum
	 */
	public int getCurGuestNum() {
		return curGuestNum;
	}

	/**
	 * @param curGuestNum the curGuestNum to set
	 */
	public void setCurGuestNum(int curGuestNum) {
		this.curGuestNum = curGuestNum;
	}

	/**
	 * @return the names
	 */
	public ArrayList<Guest> getNames() {
		return guests;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	// if the current guest number is less than the room's capacity, we can add a guest to the room
	public boolean add(Guest g) {
		if(this.curGuestNum < this.capacity) {
			guests.add(g);
			curGuestNum++;
			return true;
		}else {
			return false;
		}
	}
	
	// delete a guest from a room
	public boolean delete(Guest g) {
		if(guests != null) {
			return guests.remove(g);
		}else {
			return false;
		}
	}
	
	// check if a room is available
	public boolean isAvailable() {
	    return this.curGuestNum < this.capacity;
	}
	
	@Override
	public int compareTo(Room another) {
		if(this.getCurGuestNum() == another.getCurGuestNum()) {
			return 0;
		}
		// in descending order
		return this.getCurGuestNum() < another.getCurGuestNum() ? 1 : -1;
	}
	
	// return a room's type in string format
	public String toString() {
		return this.getType();
	}
}
