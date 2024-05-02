import java.util.*;
import java.io.*;

public class Manager extends User implements ManagerInterface{
	
	// two fields that should not be changed
	private final String username = "Manager";
	private final String password = "Manager123";
		
	// default constructor
	public Manager() {
		super();
	}
	
	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public Manager(String username, String password, String firstName, String lastName) {
		super("Manager", "Manager123", firstName, lastName);
	}
	
	// the manager can create a room
	public Room createRoom(String type, String id, double price, ArrayList<Room> rooms) {
		int curGuestNum = 0;
		Room room = new Room(type, id, curGuestNum, price);
		rooms.add(room);
		return room;
	}
	
	// the manager can delete a room
	public boolean deleteRoom(ArrayList<Room> rooms, String id) {
		if(rooms != null) {
			for(int i = 0; i < rooms.size(); i++) {
				if(rooms.get(i).getId().equalsIgnoreCase(id)) {
					return rooms.remove(rooms.get(i));
				}
			}
		}
		return false;
	}
	
	// the manager can edit the information of an existing room
	public void editRoomInfo(ArrayList<Room> rooms, String id, String newType, double newPrice) {
		for(int i = 0; i < rooms.size(); i++) {
			Room room = rooms.get(i);
			if(room.getId().equalsIgnoreCase(id)) {
				room.setType(newType);
				room.setPrice(newPrice);
			}
		}
	}
	
	// the manager can display a room's information by using its id
	public void displayRoomInfo(ArrayList<Room> rooms, String id) {
		for(int i = 0; i < rooms.size(); i++) {
			Room room = rooms.get(i);
			if(room.getId().equalsIgnoreCase(id)) {
				System.out.println(room.getType() + ", " + room.getId() + ", " + room.getCapacity() + ", " + room.getCurGuestNum() + ", " + room.getPrice());
			}
		}
	}
	
	// the manager can view all rooms
	@Override
	public void viewAllRooms(ArrayList<Room> rooms) {
		for(int i = 0; i < rooms.size(); i++) {
			Room room = rooms.get(i);
			System.out.println(room.getType() + ", " + room.getId() + ", " + room.getCapacity() + ", " + room.getCurGuestNum() + ", " + room.getPrice());
		}
	}
	
	// the manager can add a guest to a room
	public boolean addGuestToRoom(Room room, Guest guest) {
	    if(guest.ifBook() && room.isAvailable()) {
	    	room.add(guest);
	        room.setCurGuestNum(room.getCurGuestNum() + 1);
	        return true;
	    }
	    return false;
	}
	
	// the manager can edit a guest's information
	public void editGuestInfo(Guest guest, String newFirstName, String newLastName) {
	    guest.setFirstName(newFirstName);
	    guest.setLastName(newLastName);
	}
	
	// the manager can remove a guest from an assigned room after checking out
	public boolean removeGuestFromRoom(Room room, Guest guest) {
	    if (!guest.ifLeave()) {
	        return false;
	    }
	    if (room.getNames().remove(guest)) {
	        room.setCurGuestNum(room.getCurGuestNum() - 1);
	        return true;
	    }
	    return false;
	}


	// the manager can search for a guest by name
	public Guest searchGuest(ArrayList<Guest> guests, String firstName, String lastName) {
	    for (int i = 0; i < guests.size(); i++) {
	    	Guest guest = guests.get(i);
	        if (guest.getFirstName().equalsIgnoreCase(firstName) && guest.getLastName().equalsIgnoreCase(lastName)) {
	            return guest;
	        }
	    }
	    return null;
	}
}
