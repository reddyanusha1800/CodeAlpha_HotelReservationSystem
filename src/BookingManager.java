import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager {

    private Hotel hotel;
    private ArrayList<Reservation> reservations;
    private Scanner sc;
    private int reservationCounter;

    public BookingManager() {
        hotel = new Hotel();
        reservations = new ArrayList<>();
        sc = new Scanner(System.in);
        reservationCounter = 1001;

        FileManager.loadAvailability(hotel);
    }

    // Display Available Rooms
    public void displayAvailableRooms() {
        hotel.displayAvailableRooms();
    }

    // Search Room
    public void searchRoom() {

        System.out.print("Enter Room Number : ");
        int roomNumber = sc.nextInt();

        hotel.searchRoom(roomNumber);
    }

    // Book Room
    public void bookRoom() {

        System.out.println("\n========== BOOK ROOM ==========");

        System.out.print("Customer Name : ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Phone Number : ");
        String phone = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        hotel.displayAvailableRooms();

        System.out.print("\nEnter Room Number : ");
        int roomNumber = sc.nextInt();

        Room room = hotel.findRoom(roomNumber);

        if (room == null) {

            System.out.println("Invalid Room Number.");
            return;

        }

        if (!room.isAvailable()) {

            System.out.println("Room already booked.");
            return;

        }

        System.out.print("Number of Days : ");
        int days = sc.nextInt();

        double total = room.getPrice() * days;

        Payment payment = new Payment(total);

        boolean success = payment.makePayment();

        if (!success) {

            System.out.println("Booking Cancelled.");
            return;

        }

        Customer customer =
                new Customer(name, phone, email);

        Reservation reservation =
                new Reservation(
                        reservationCounter,
                        customer,
                        room,
                        days,
                        "Paid"
                );

        reservations.add(reservation);

        room.setAvailable(false);

        FileManager.saveBookings(reservations);

        FileManager.saveAvailability(hotel);

        System.out.println("\nBooking Successful!");

        System.out.println("Reservation ID : "
                + reservationCounter);

        reservationCounter++;
    }
        // Cancel Reservation
    public void cancelReservation() {

        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations found.");
            return;
        }

        System.out.print("\nEnter Reservation ID to Cancel: ");
        int reservationId = sc.nextInt();

        Reservation reservation = findReservation(reservationId);

        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }

        Room room = reservation.getRoom();
        room.setAvailable(true);

        reservations.remove(reservation);

        FileManager.saveBookings(reservations);
        FileManager.saveAvailability(hotel);

        System.out.println("Reservation cancelled successfully.");
    }

    // View All Reservations
    public void viewReservations() {

        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations available.");
            return;
        }

        System.out.println("\n========== RESERVATIONS ==========");

        for (Reservation reservation : reservations) {
            reservation.displayReservation();
        }

        System.out.println("==================================");
    }

    // Find Reservation by ID
    private Reservation findReservation(int reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }

        }

        return null;
    }

}