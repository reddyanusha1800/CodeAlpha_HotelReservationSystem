public class Reservation {

    private int reservationId;
    private Customer customer;
    private Room room;
    private int numberOfDays;
    private double totalAmount;
    private String paymentStatus;

    // Constructor
    public Reservation(int reservationId, Customer customer, Room room,
                       int numberOfDays, String paymentStatus) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.totalAmount = room.getPrice() * numberOfDays;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setter
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Display Reservation Details
    public void displayReservation() {

        System.out.println("\n==========================================");
        System.out.println("         RESERVATION DETAILS");
        System.out.println("==========================================");

        System.out.println("Reservation ID : " + reservationId);

        customer.displayCustomer();

        System.out.println("Room Number    : " + room.getRoomNumber());
        System.out.println("Room Category  : " + room.getCategory());
        System.out.println("Price/Night    : ₹" + room.getPrice());

        System.out.println("Number of Days : " + numberOfDays);
        System.out.println("Total Amount   : ₹" + totalAmount);
        System.out.println("Payment Status : " + paymentStatus);

        System.out.println("==========================================");
    }

    // Save Reservation to File
    @Override
    public String toString() {

        return reservationId + "," +
                customer.getName() + "," +
                customer.getPhone() + "," +
                customer.getEmail() + "," +
                room.getRoomNumber() + "," +
                room.getCategory() + "," +
                numberOfDays + "," +
                totalAmount + "," +
                paymentStatus;
    }
}