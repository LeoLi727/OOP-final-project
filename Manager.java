import java.util.*;
import java.io.*;

public class Manager extends User implements ManagerInterface, java.io.Serializable {

    // default constructor
    public Manager() {
        super();
    }

    public Manager(String username, String password, String firstName, String lastName, RoomFacade roomFacade) {
        super(username, password, firstName, lastName, roomFacade);
    }

    @Override
    public void view_all_rooms() {
        roomFacade.print_all_rooms();
    }

    @Override
    public void view_available_rooms() {
        roomFacade.print_all_available_rooms();
    }

    @Override
    public void view_non_available_rooms() {
        roomFacade.print_all_non_available_rooms();
    }

    @Override
    public void create_room() {
        roomFacade.create_room();
    }

    @Override
    public void delete_room() {
        roomFacade.delete_room();
    }

    @Override
    public void register_new_guest() {
        roomFacade.register_new_guest(roomFacade);
    }

    @Override
    public void edit_room() {
        roomFacade.edit_room();
    }


    @Override
    public void view_guests_in_specific_room() {
        roomFacade.view_guest_by_room_number();
    }

    @Override
    public void view_list_of_rooms_for_a_given_guest() {
        roomFacade.show_specific_guest_rooms();
    }

    @Override
    public void show_all_guests() {
        roomFacade.show_all_guests();
    }


}
