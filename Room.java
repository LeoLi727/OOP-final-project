import java.util.*;

public class Room implements java.io.Serializable {

    // Attributes of Room object
    private String type;
    private String room_number;
    private int capacity;
    private int curGuestNum;
    private final ArrayList<Guest> guests_of_a_room = new ArrayList<>();
    private double price;
    private boolean booked = false;


    // default constructor
    public Room() {
        this.type = "xxx";
        this.room_number = "xxx";
        this.capacity = -1;
        this.curGuestNum = 0;
        this.price = 0;
    }

    // constructor with parameters
    public Room(String type, String room_number, int capacity, double price) {
        this.type = type;
        this.room_number = room_number;
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

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
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
        System.out.println("+-----------------------------------+");
        System.out.println("|          Room Details             |");
        System.out.println("+-----------------------------------+");
        System.out.println("| Room Type:          " + this.type);
        System.out.println("| Room Number:        " + this.room_number);
        System.out.println("| Capacity:           " + this.capacity);
        System.out.println("| Current Guests:     " + this.curGuestNum);
        System.out.println("| Price:              " + this.price);
        if (!guests_of_a_room.isEmpty()) {
            System.out.println("| Guests in Room: ");
            for (Guest guest : guests_of_a_room) {
                System.out.println("|   - Guest Name:     " + guest.getFirstName() + " " + guest.getLastName());
            }
        }
        System.out.println("+-----------------------------------+");
        System.out.println();
    }


    public void displayRoomDetailsGuestVersion() {
        System.out.println("+-----------------------------------+");
        System.out.println("|          Room Details             |");
        System.out.println("+-----------------------------------+");
        System.out.println("| Room Type:          " + this.type);
        System.out.println("| Room Number:        " + this.room_number);
        System.out.println("| Capacity:           " + this.capacity);
        System.out.println("| Current Guests:     " + this.curGuestNum);
        System.out.println("| Price:              " + this.price);
        System.out.println("+-----------------------------------+");
        System.out.println();
    }


}
