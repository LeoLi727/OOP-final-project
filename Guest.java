import java.util.*;

public class Guest extends User implements GuestInterface, java.io.Serializable {
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

    public Guest(String username, String password, String firstname, String lastname, RoomFacade roomFacade) {
        super(username, password, firstname, lastname, roomFacade);
    }

    public Guest(String firstname, String lastname) {
        super(firstname, lastname);
    }

    @Override
    public void show_name() {
        System.out.println("+---------------------------------+");
        System.out.println("|           Guest Name            |");
        System.out.println("+---------------------------------+");
        System.out.println("| First Name:   " + this.firstName);
        System.out.println("| Last Name:    " + this.lastName);
        System.out.println("+---------------------------------+");
    }


    @Override
    public void book_room() {
        roomFacade.book_room(this.username);
    }

    @Override
    public void checkout() {
        roomFacade.checkout(this.username);
    }

    @Override
    public void add_guest() {
        roomFacade.add_guest(this.username);
    }

    @Override
    public void view_booked_rooms() {
        roomFacade.view_all_booked_room_for_a_guest(room_list_for_guest);
    }

    @Override
    public void show_guest_info() {
        System.out.println("+---------------------------------------+");
        System.out.println("|          Guest Information            |");
        System.out.println("+---------------------------------------+");
        System.out.println("| First Name:       " + firstName);
        System.out.println("| Last Name:        " + lastName);
        System.out.println("| Username:         " + username);
        System.out.println("| Password:         " + password);
        System.out.println("+---------------------------------------+");
    }


    @Override
    public void view_all_rooms() {
        roomFacade.print_all_rooms_g();
    }

    @Override
    public void view_available_rooms() {
        roomFacade.print_all_available_rooms_g();
    }

    @Override
    public void view_non_available_rooms() {
        roomFacade.print_all_non_available_rooms_g();
    }
}
