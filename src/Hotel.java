import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;

    // Constructor
    public Hotel() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    // Create default rooms
    private void initializeRooms() {

        rooms.add(new Room(101, "Standard", 2000, true));
        rooms.add(new Room(102, "Standard", 2000, true));

        rooms.add(new Room(201, "Deluxe", 3500, true));
        rooms.add(new Room(202, "Deluxe", 3500, true));

        rooms.add(new Room(301, "Suite", 6000, true));
        rooms.add(new Room(302, "Suite", 6000, true));
    }

    // Return all rooms
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // Find room using room number
    public Room findRoom(int roomNumber) {

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    // Display all rooms
    public void displayAllRooms() {

        System.out.println("\n========== ALL ROOMS ==========");

        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    // Display only available rooms
    public void displayAvailableRooms() {

        System.out.println("\n====== AVAILABLE ROOMS ======");

        boolean found = false;

        for (Room room : rooms) {

            if (room.isAvailable()) {
                room.displayRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms are available.");
        }
    }

    // Search room by room number
    public void searchRoom(int roomNumber) {

        Room room = findRoom(roomNumber);

        if (room != null) {

            System.out.println("\nRoom Found");
            room.displayRoom();

        } else {

            System.out.println("Room not found.");
        }
    }
}
