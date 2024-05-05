import java.io.*;
import java.util.Scanner;

public class HotelManagementApplication {
    public static void serialize(RoomFacade data) {
        try {
            FileOutputStream fos = new FileOutputStream("room_facade.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();
            System.out.println("Saved. Good Bye!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RoomFacade roomFacade;
        try {
            FileInputStream fis = new FileInputStream("room_facade.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            roomFacade = (RoomFacade) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("This is the first time you use this system. Reading files from csv...");
            roomFacade = new RoomFacade();
        }
        Manager manager = new Manager("manager", "manager001", "steve", "jobs", roomFacade);
        boolean continuep = true;
        while (continuep) {
            System.out.print("Please enter your username: ");
            String username = input.nextLine();
            System.out.print("Please enter your password: ");
            String password = input.nextLine();
            if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                System.out.println("\nWelcome manager " + manager.getFirstName() + " " + manager.getLastName());
                while (continuep) {
                    System.out.println("+--------------------------------------+");
                    System.out.println("|              Main Menu               |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("| Option |          Description        |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("|   1    |     Room Management         |");
                    System.out.println("|   2    |            Reports          |");
                    System.out.println("|   3    |             Exit            |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("\nPlease enter your selection: ");
                    String selection = input.nextLine();
                    switch (selection) {
                        case "1" -> {
                            System.out.println("+--------------------------------------+");
                            System.out.println("|         Room Management Menu         |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("| Option |          Description        |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("|   1    |     Create a new room       |");
                            System.out.println("|   2    |     Delete a room           |");
                            System.out.println("|   3    |     Edit a room             |");
                            System.out.println("|   4    |     Register a new guest    |");
                            System.out.println("|   5    |     Exit                    |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("\nPlease enter your selection: ");
                            String selection2 = input.nextLine();
                            switch (selection2) {
                                case "1" -> manager.create_room();
                                case "2" -> manager.delete_room();
                                case "3" -> manager.edit_room();
                                case "4" -> manager.register_new_guest();
                                case "5" -> {
                                    serialize(manager.getRoomFacade());
                                    continuep = false;
                                }
                                default -> System.out.println("Invalid command. Try again.");
                            }
                        }
                        case "2" -> {
                            System.out.println("+--------------------------------------+");
                            System.out.println("|           Reports Menu               |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("| Option |          Description        |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("|   1    |     View all rooms          |");
                            System.out.println("|   2    |     View all available room |");
                            System.out.println("|   3    |     View all non available  |");
                            System.out.println("|        |     rooms                   |");
                            System.out.println("|   4    |     View guests in a        |");
                            System.out.println("|        |     specific room           |");
                            System.out.println("|   5    |     View rooms for a        |");
                            System.out.println("|        |     given guest             |");
                            System.out.println("|   6    |     View all registered     |");
                            System.out.println("|        |     guests                  |");
                            System.out.println("|   7    |     Exit                    |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("\nPlease enter your selection: ");
                            String selection3 = input.nextLine();
                            switch (selection3) {
                                case "1" -> manager.view_all_rooms();
                                case "2" -> manager.view_available_rooms();
                                case "3" -> manager.view_non_available_rooms();
                                case "4" -> manager.view_guests_in_specific_room();
                                case "5" -> manager.view_list_of_rooms_for_a_given_guest();
                                case "6" -> manager.show_all_guests();
                                case "7" -> {
                                    serialize(manager.getRoomFacade());
                                    continuep = false;
                                }
                                default -> System.out.println("Invalid command. Try again.");
                            }
                        }
                        case "3" -> {
                            serialize(manager.getRoomFacade());
                            continuep = false;
                        }
                        default -> System.out.println("Invalid command. Try again.");
                    }
                }
            } else if (manager.find_guest(username, password) != null) {
                Guest guest = manager.find_guest(username, password);
                System.out.println("\nWelcome guest " + guest.getFirstName() + " " + guest.getLastName());
                while (continuep) {
                    System.out.println("+--------------------------------------+");
                    System.out.println("|             Guest Menu               |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("| Option |          Description        |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("|   1    |     View all rooms          |");
                    System.out.println("|   2    |     View available rooms    |");
                    System.out.println("|   3    |     View non-available room |");
                    System.out.println("|   4    |     Book a room             |");
                    System.out.println("|   5    |     View booked rooms       |");
                    System.out.println("|   6    |     Add guests to a room    |");
                    System.out.println("|   7    |     Checkout                |");
                    System.out.println("|   8    |     View Account Detail     |");
                    System.out.println("|   9    |     Exit                    |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("\nPlease enter your selection: ");
                    String selection = input.nextLine();
                    switch (selection) {
                        case "1" -> guest.view_all_rooms();
                        case "2" -> guest.view_available_rooms();
                        case "3" -> guest.view_non_available_rooms();
                        case "4" -> guest.book_room();
                        case "5" -> guest.view_booked_rooms();
                        case "6" -> guest.add_guest();
                        case "7" -> guest.checkout();
                        case "8" -> guest.show_guest_info();
                        case "9" -> {
                            serialize(manager.getRoomFacade());
                            continuep = false;
                        }
                        default -> System.out.println("Invalid command. Try again.");
                    }
                }
            } else
                System.out.println("Invalid password or username");
        }
        input.close();
    }
}
