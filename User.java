// parent class for the guest and manager classes
public abstract class User implements java.io.Serializable {

    protected RoomFacade roomFacade;
    protected String username, password, firstName, lastName;

    // default constructor
    public User() {
    }

    // the constructor that takes four parameters
    public User(String username, String password, String firstName, String lastName, RoomFacade roomFacade) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomFacade = roomFacade;
    }

    public User(String firstName, String lastName) {
        this.username = "xxx";
        this.password = "xxx";
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RoomFacade getRoomFacade() {
        return roomFacade;
    }

    public void setRoomFacade(RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract void view_all_rooms();

    public abstract void view_available_rooms();

    public abstract void view_non_available_rooms();

    public Guest find_guest(String a, String b) {
        return roomFacade.find_guest(a, b);
    }


}
