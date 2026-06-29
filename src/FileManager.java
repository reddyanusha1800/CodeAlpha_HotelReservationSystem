import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String BOOKINGS_FILE = "bookings.txt";
    private static final String AVAILABILITY_FILE = "availability.txt";

    // Save Reservations
    public static void saveBookings(ArrayList<Reservation> reservations) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKINGS_FILE))) {

            for (Reservation reservation : reservations) {
                writer.println(reservation.toString());
            }

        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }

    // Display Saved Reservations
    public static void loadBookings() {

        File file = new File(BOOKINGS_FILE);

        if (!file.exists()) {
            System.out.println("No bookings found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            System.out.println("\n========== BOOKING RECORDS ==========");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("=====================================");

        } catch (IOException e) {
            System.out.println("Error reading bookings.");
        }
    }

    // Save Room Availability
    public static void saveAvailability(Hotel hotel) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(AVAILABILITY_FILE))) {

            for (Room room : hotel.getRooms()) {

                writer.println(
                        room.getRoomNumber() + "," +
                        room.isAvailable()
                );

            }

        } catch (IOException e) {
            System.out.println("Error saving availability.");
        }

    }

    // Load Room Availability
    public static void loadAvailability(Hotel hotel) {

        File file = new File(AVAILABILITY_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int roomNumber = Integer.parseInt(data[0]);
                boolean available = Boolean.parseBoolean(data[1]);

                Room room = hotel.findRoom(roomNumber);

                if (room != null) {
                    room.setAvailable(available);
                }

            }

        } catch (IOException e) {

            System.out.println("Error loading room availability.");

        }

    }

}
