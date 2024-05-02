import java.io.*;
import java.util.*;

public interface ManagerInterface {
	
	public Room createRoom(String type, String id, double price, ArrayList<Room> rooms);
	public boolean deleteRoom(ArrayList<Room> rooms, String id);
	public void editRoomInfo(ArrayList<Room> rooms, String id, String newType, double newPrice);
	public void displayRoomInfo(ArrayList<Room> rooms, String id);
	public void viewAllRooms(ArrayList<Room> rooms);
	public boolean addGuestToRoom(Room room, Guest guest);
	public void editGuestInfo(Guest guest, String newFirstName, String newLastName);
	public boolean removeGuestFromRoom(Room room, Guest guest);
	public Guest searchGuest(ArrayList<Guest> guests, String firstName, String lastName);
}
