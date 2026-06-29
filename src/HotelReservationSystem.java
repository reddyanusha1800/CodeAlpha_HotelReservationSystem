import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingManager bookingManager = new BookingManager();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("       HOTEL RESERVATION SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Search Room");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Reservations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookingManager.displayAvailableRooms();
                    break;

                case 2:
                    bookingManager.searchRoom();
                    break;

                case 3:
                    bookingManager.bookRoom();
                    break;

                case 4:
                    bookingManager.cancelReservation();
                    break;

                case 5:
                    bookingManager.viewReservations();
                    break;

                case 6:
                    System.out.println("\nThank you for using Hotel Reservation System.");
                    System.out.println("Visit Again!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}