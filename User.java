import java.io.*;
import java.util.*;

// parent class for the guest and manager classes
public abstract class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	// default constructor
	public User() {
			
	}
	
	// the constructor that takes two parameters
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// the constructor that takes four parameters
	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// a method that will be inherited by the Guest and Manager classes
	public void viewAllRooms(ArrayList<Room> rooms) {
		int i = 0;
		while(i < rooms.size()) {
			Room room = rooms.get(i);
			System.out.println(room.getType());
			i++;
		}
	}
}
