import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomFacade implements java.io.Serializable {
    private ArrayList<Room> room_list = new ArrayList<>();
    private ArrayList<Guest> guest_list = new ArrayList<>();

    public ArrayList<Room> getRoom_list() {
        return room_list;
    }

    public void setRoom_list(ArrayList<Room> room_list) {
        this.room_list = room_list;
    }

    public ArrayList<Guest> getGuest_list() {
        return guest_list;
    }

    public void setGuest_list(ArrayList<Guest> guest_list) {
        this.guest_list = guest_list;
    }

    // read hotel detail from pre-set csv file.
    public RoomFacade() {
        String[] token;
        String line;
        try {
            FileReader fileReader = new FileReader("HotelRoomFile.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                token = line.split(",");
                Room newEntry = new Room();
                if (!token[0].equals("type")) {
                    newEntry.setType(token[0]);
                    newEntry.setRoom_number(token[1]);
                    newEntry.setCapacity(Integer.parseInt(token[2]));
                    newEntry.setPrice(Double.parseDouble(token[5]));
                    room_list.add(newEntry);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO Exception");
            ex.printStackTrace();
        }
    }

    public int find_index_by_room_number(String room_number) {
        int find = -2;
        for (int i = 0; i < room_list.size(); i++) {
            if (room_list.get(i).getRoom_number().equals(room_number)) {
                find = i;
                break;
            }
        }
        return find;
    }

    public int find_index_by_first_and_last_name(String firstname, String lastname) {
        int find = -2;
        for (int i = 0; i < guest_list.size(); i++) {
            if (guest_list.get(i).getFirstName().equals(firstname) && guest_list.get(i).getLastName().equals(lastname)) {
                find = i;
                break;
            }
        }
        return find;
    }

    public int find_index_by_usernmae_and_password(String username, String password) {
        int find = -2;
        for (int i = 0; i < guest_list.size(); i++) {
            if (guest_list.get(i).getUsername().equals(username) && guest_list.get(i).getPassword().equals(password)) {
                find = i;
                break;
            }
        }
        return find;
    }

    public int find_index_by_username(String username) {
        int find = -2;
        for (int i = 0; i < guest_list.size(); i++) {
            if (guest_list.get(i).getUsername().equals(username)) {
                find = i;
                break;
            }
        }
        return find;
    }

    public void create_room() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Creating new room...");
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        // room number exists
        if (find_index_by_room_number(room_number) != -2) {
            System.out.println("Room Number existed.\n Stop Creating");
        }
        // room number not exists, a new room
        else {
            System.out.print("Enter room type: ");
            String room_type = input1.nextLine();
            System.out.print("Enter capacity: ");
            int capacity = Integer.parseInt(input1.nextLine());
            System.out.print("Enter price: ");
            double price = Double.parseDouble(input1.nextLine());
            Room newRoom = new Room(room_type, room_number, capacity, price);
            room_list.add(newRoom);
            System.out.println("Room Created Successfully");
        }

    }

    public void delete_room() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        int index = find_index_by_room_number(room_number);
        if (index != -2) {
            if (!room_list.get(index).isBooked()) {
                room_list.remove(index);
                System.out.println("room deleted successfully");
            } else {
                System.out.println("Cannot delete, somebody is staying at this room");
            }

        } else System.out.println("room deleted unsuccessfully. no such room found");
    }

    public void edit_room() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        int index = find_index_by_room_number(room_number);
        if (index != -2) {
            if (!room_list.get(index).isBooked()) {
                System.out.print("Type in the room type you want to change: ");
                room_list.get(index).setType(input1.nextLine());
                System.out.print("Type in the capacity you want to change: ");
                room_list.get(index).setCapacity(Integer.parseInt(input1.nextLine()));
                System.out.print("Type in the current number of guest you want to change: ");
                room_list.get(index).setCurGuestNum(Integer.parseInt(input1.nextLine()));
                System.out.print("Type in the price you want to change: ");
                room_list.get(index).setPrice(Double.parseDouble(input1.nextLine()));
                System.out.println("Room edited successfully");
            } else {
                System.out.println("Cannot edit, somebody is staying at this room");
            }
        } else System.out.println("Room edited unsuccessfully. no such room found");
    }


    public void print_all_rooms() {
        for (Room room : room_list) {
            room.displayRoomDetails();
        }
    }

    public void print_all_available_rooms() {
        for (Room room : room_list) {
            if (!room.isBooked()) {
                room.displayRoomDetails();
            }
        }
    }

    public void print_all_non_available_rooms() {
        for (Room room : room_list) {
            if (room.isBooked()) {
                room.displayRoomDetails();
            }
        }
    }

    public void print_all_rooms_g() {
        for (Room room : room_list) {
            room.displayRoomDetailsGuestVersion();
        }
    }

    public void print_all_available_rooms_g() {
        for (Room room : room_list) {
            if (!room.isBooked()) {
                room.displayRoomDetailsGuestVersion();
            }
        }
    }

    public void print_all_non_available_rooms_g() {
        for (Room room : room_list) {
            if (room.isBooked()) {
                room.displayRoomDetailsGuestVersion();
            }
        }
    }

    public void book_room(String username) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        System.out.print("Enter the how many people will stay in this room: ");
        int guest_num = Integer.parseInt(input1.nextLine());
        int index = find_index_by_room_number(room_number);
        int guest_index = find_index_by_username(username);
        if (index != -2 && guest_index != -2) {
            if (room_list.get(index).isBooked()) {
                System.out.println("Room has benn booked!");
            } else if (room_list.get(index).getCapacity() < guest_num) {
                System.out.println("number of guests is more than capacity of this room");
            } else {
                room_list.get(index).getGuests_of_a_room().add(guest_list.get(guest_index));
                guest_list.get(guest_index).getRoom_list_for_guest().add(room_list.get(index));
                room_list.get(index).setCurGuestNum(guest_num);
                room_list.get(index).setBooked(true);
                if (guest_num > 1) {
                    while (guest_num-- > 1) {
                        System.out.print("Enter Guest's firstname: ");
                        String firstName = input1.nextLine();
                        System.out.print("Enter Guest's lastname: ");
                        String lastName = input1.nextLine();
                        room_list.get(index).getGuests_of_a_room().add(new Guest(firstName, lastName));
                        System.out.println("Add Guest Successfully!");
                    }
                } else {
                    System.out.println("Booked Successfully!");
                }
            }
        } else {
            if (index == -2) System.out.println("no such room found!");
            else System.out.println("no such guest found, you have to register to book a room!");
        }
    }

    public void add_guest(String username) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        int index = find_index_by_room_number(room_number);
        int guest_index = find_index_by_username(username);
        if (index != -2 && guest_index != -2) {
            if (!room_list.get(index).getGuests_of_a_room().contains(guest_list.get(guest_index))){
                System.out.println("you did not book this room");
            } else if (room_list.get(index).getCurGuestNum() + 1 > room_list.get(index).getCapacity()) {
                System.out.println("number of guests is more than capacity of this room");
            } else {
                System.out.print("Enter Guest's firstname: ");
                String firstName = input1.nextLine();
                System.out.print("Enter Guest's lastname: ");
                String lastName = input1.nextLine();
                room_list.get(index).getGuests_of_a_room().add(new Guest(firstName, lastName));
                room_list.get(index).setCurGuestNum(room_list.get(index).getCurGuestNum() + 1);
                System.out.println("Add Guest Successfully!");
            }
        } else {
            if (index == -2) System.out.println("no such room found!");
            else System.out.println("no such guest found, you have to register to book a room!");
        }
    }

    public void checkout(String username) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String room_number = input1.nextLine();
        int index = find_index_by_room_number(room_number);
        int guest_index = find_index_by_username(username);
        if (index != -2 && guest_index != -2) {
            if (room_list.get(index).isBooked() && room_list.get(index).getGuests_of_a_room().contains(guest_list.get(guest_index))) {
                room_list.get(index).getGuests_of_a_room().clear();
                room_list.get(index).setCurGuestNum(0);
                guest_list.get(guest_index).getRoom_list_for_guest().remove(room_list.get(index));
                System.out.println("checkout Successfully!");
            } else {
                System.out.println("You didn't book this room!");
            }
        } else {
            if (index == -2) System.out.println("no such room found!");
            else System.out.println("no such guest found!");
        }
    }



}
