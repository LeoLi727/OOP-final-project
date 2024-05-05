#Hotel Reservation System

Having an efficient reservation system is essential for the business of a hotel. To achieve this goal, we decide to
develop a hotel reservation system. This platform will be developed using Java.

## Major functionalities

Our system is designed for two kinds of users: guests and managers. A guest can use this application to browse rooms'
information and show your booking or leaving intention to the hotel manager. At the same time, a hotel manager can also
use this system, including creating rooms, deleting rooms, editing rooms, browsing room information, checking room
availability,
adding, removing a guest, etc.

We prepared accounts

| Role    | Username | Password   |
|---------|----------|------------|
| Manager | manager  | manager001 |
| Guest   | user     | user001    |


## Use Case Diagram

### Manager Use Case 

![usecase_m.svg](diagrams%2Fusecase_m.svg)

| UC REFERENCE | USECASE NAME                   | OVERVIEW                                                       | RELATED USE CASES         | ACTORS  | PRE CONDITIONS                          | POST CONDITIONS                              |
|--------------|--------------------------------|----------------------------------------------------------------|---------------------------|---------|-----------------------------------------|----------------------------------------------|
| UC1          | Room Management                | Access management functions related to room operations.        | UC2, UC3, UC4, UC5        | Manager | Manager must be logged in.              | Access to room management functionalities.   |
| UC2          | Create a new room              | Allows the manager to add a new room to the hotel.             | UC1                       | Manager | Manager is in the Room Management menu. | A new room is added to the system.           |
| UC3          | Delete a room                  | Permits the manager to remove an existing room from the hotel. | UC1                       | Manager | Manager selects a room to delete.       | The room is removed from the system.         |
| UC4          | Edit a room                    | Enables the manager to modify the details of an existing room. | UC1                       | Manager | A room to edit is selected.             | Room details are updated.                    |
| UC5          | Register a new guest           | Allows the manager to add a new guest to the system.           | UC1                       | Manager | Manager is in the Room Management menu. | A new guest is registered in the system.     |
| UC6          | Reports                        | Access reports related to room and guest management.           | UC7, UC8, UC9, UC10, UC11 | Manager | Manager selects the Reports menu.       | Access to various reports is provided.       |
| UC7          | View all rooms                 | Manager can see all rooms, irrespective of their status.       | UC6, UC8, UC9             | Manager | Manager is in the Reports menu.         | List of all rooms is displayed.              |
| UC8          | View all available rooms       | Displays all rooms currently available for booking.            | UC7                       | Manager | Part of viewing all rooms.              | List of available rooms is displayed.        |
| UC9          | View all non-available rooms   | Displays rooms that are currently booked or unavailable.       | UC7                       | Manager | Part of viewing all rooms.              | List of non-available rooms displayed.       |
| UC10         | View guests in a specific room | Shows details of guests currently staying in a specific room.  | UC6, UC7                  | Manager | Manager selects a specific room.        | Guest details for the room are displayed.    |
| UC11         | View rooms for a given guest   | Shows all rooms associated with a specific guest.              | UC6, UC7                  | Manager | Manager selects a guest.                | List of rooms booked by the guest displayed. |
| UC12         | View all registered guests     | Shows a list of all guests registered in the hotel.            | UC6, UC7                  | Manager | Manager is in the Reports menu.         | List of all guests is displayed.             |

### Guest Use Case 

![usecase_g.svg](diagrams%2Fusecase_g.svg)

| UC REFERENCE | USECASE NAME             | OVERVIEW                                                    | RELATED USE CASES | ACTORS | PRE CONDITIONS                | POST CONDITIONS                         |
|--------------|--------------------------|-------------------------------------------------------------|-------------------|--------|-------------------------------|-----------------------------------------|
| UC1          | View all rooms           | Guest can view all rooms, regardless of availability.       | UC2, UC3, UC5     | Guest  | Guest is logged in.           | List of all rooms is displayed.         |
| UC2          | View available rooms     | Guest views rooms that are currently available for booking. | UC1               | Guest  | Guest selects to view rooms.  | List of available rooms is displayed.   |
| UC3          | View non-available rooms | Guest sees rooms that are currently not available.          | UC1               | Guest  | Guest selects to view rooms.  | List of non-available rooms displayed.  |
| UC4          | Book a room              | Guest books a room for a specific date.                     | None              | Guest  | Guest selects a room to book. | Room booking is confirmed.              |
| UC5          | View booked rooms        | Guest views all rooms they have booked.                     | UC1               | Guest  | Guest is logged in.           | List of booked rooms is displayed.      |
| UC6          | Add guests to a room     | Guest can add more guests to their room booking.            | UC4               | Guest  | Guest has a booked room.      | Additional guests are added to booking. |
| UC7          | Checkout                 | Guest checks out of a room, ending their booking.           | None              | Guest  | Guest decides to end stay.    | Checkout process is completed.          |
| UC8          | View Account Detail      | Guest views their account details and booking history.      | None              | Guest  | Guest accesses their account. | Account details are displayed.          |

## Sequence Diagram

### Manager's sequence diagram

- create a room
  ![create_room.svg](diagrams%2Fcreate_room.svg)
- delete a room
  ![delete_room.svg](diagrams%2Fdelete_room.svg)
- edit a room
  ![edit_room.svg](diagrams%2Fedit_room.svg)
- register a new guest
  ![register_guest.svg](diagrams%2Fregister_guest.svg)
- view all rooms
  ![viewall_m.svg](diagrams%2Fviewall_m.svg)
- view all available rooms
  ![viewavailable_m.svg](diagrams%2Fviewavailable_m.svg)
- view non all available rooms
  ![viewnonavailable.svg](diagrams%2Fviewnonavailable.svg)
- View guests in a specific room
  ![view_guests_in_specific_room.svg](diagrams%2Fview_guests_in_specific_room.svg)
- View rooms for a given guest
  ![view_list_of_rooms_for_a_given_guest.svg](diagrams%2Fview_list_of_rooms_for_a_given_guest.svg)
- View all registered guests
  ![show_all_guests.svg](diagrams%2Fshow_all_guests.svg)

### Guest's sequence diagram

- book a room
  ![book_room.svg](diagrams%2Fbook_room.svg)
- checkout
  ![checkout.svg](diagrams%2Fcheckout.svg)
- view booked rooms
  ![view_booked_rooms.svg](diagrams%2Fview_booked_rooms.svg)
- add guests to a room
  ![add_guest.svg](diagrams%2Fadd_guest.svg)
- view all rooms
  ![viewall_m.svg](diagrams%2Fviewall_g.svg)
- view all available rooms
  ![viewavailable_m.svg](diagrams%2Fviewavailable_g.svg)
- view non all available rooms
  ![viewnonavailable.svg](diagrams%2Fviewnonavailable_g.svg)
- view account detail
- 
  ![show_guest_info.svg](diagrams%2Fshow_guest_info.svg)

## Class Diagram
![class.svg](diagrams%2Fclass.svg)