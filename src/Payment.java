import java.util.Scanner;

public class Payment {

    private double amount;
    private String paymentMethod;
    private boolean paymentSuccessful;
    // Shared scanner to avoid resource leak from creating multiple scanners on System.in
    private static final Scanner scanner = new Scanner(System.in);

    // Constructor
    public Payment(double amount) {
        this.amount = amount;
        this.paymentMethod = "";
        this.paymentSuccessful = false;
    }

    // Process Payment
    public boolean makePayment() {
        Scanner sc = scanner;

        System.out.println("\n==================================");
        System.out.println("        PAYMENT DETAILS");
        System.out.println("==================================");
        System.out.println("Amount to Pay : ₹" + amount);

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Card");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                paymentMethod = "Cash";
                paymentSuccessful = true;
                break;

            case 2:
                paymentMethod = "UPI";
                paymentSuccessful = true;
                break;

            case 3:
                paymentMethod = "Card";
                paymentSuccessful = true;
                break;

            default:
                System.out.println("Invalid payment option!");
                paymentSuccessful = false;
                return false;
        }

        System.out.println("\nProcessing Payment...");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Payment Successful!");
        System.out.println("Payment Method : " + paymentMethod);
        System.out.println("==================================");

        return true;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    // Display Payment Details
    public void displayPayment() {
        System.out.println("\n========== PAYMENT ==========");
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Method         : " + paymentMethod);
        System.out.println("Status         : "
                + (paymentSuccessful ? "Paid" : "Pending"));
        System.out.println("=============================");
    }

    @Override
    public String toString() {
        return amount + "," + paymentMethod + ","
                + (paymentSuccessful ? "Paid" : "Pending");
    }
}