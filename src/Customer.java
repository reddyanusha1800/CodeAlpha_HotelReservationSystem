public class Customer {

    private String name;
    private String phone;
    private String email;

    // Constructor
    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display Customer Details
    public void displayCustomer() {
        System.out.println("----------------------------------------");
        System.out.println("Customer Name : " + name);
        System.out.println("Phone Number  : " + phone);
        System.out.println("Email         : " + email);
        System.out.println("----------------------------------------");
    }

    // Save Customer Data to File
    @Override
    public String toString() {
        return name + "," + phone + "," + email;
    }
}