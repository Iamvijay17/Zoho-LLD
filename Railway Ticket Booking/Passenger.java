// Passenger class to represent a railway ticket passenger
public class Passenger {
    // Private field for passenger's name
    private String name;
    // Private field for passenger's age
    private int age;
    // Private field for passenger's gender
    private String gender;
    // Private field for passenger's berth preference (l, m, u)
    private String berthPreference;
    // Private field for the allocated berth type
    private String allocatedBerth;
    // Private field for unique ticket ID
    private int ticketId;
    // Private field for ticket status (confirmed, rac, waiting)
    private String status;

    // Constructor to initialize a Passenger object with all details
    Passenger(String name, int age, String gender, String berthPreference, int ticketId, String status) {
        // Set the name
        this.name = name;
        // Set the age
        this.age = age;
        // Set the gender
        this.gender = gender;
        // Set the berth preference
        this.berthPreference = berthPreference;
        // Set the ticket ID
        this.ticketId = ticketId;
        // Set the status
        this.status = status;
    }

    // Getter method for gender
    public String getGender() {
        // Return the gender
        return gender;
    }

    // Getter method for ticket ID
    public int getTicketId() {
        // Return the ticket ID
        return ticketId;
    }

    // Getter method for age
    public int getAge() {
        // Return the age
        return age;
    }

    // Getter method for allocated berth
    public String getAllocatedBerth() {
        // Return the allocated berth
        return allocatedBerth;
    }

    // Setter method for allocated berth
    public void setAllocatedBerth(String allocatedBerth) {
        // Set the allocated berth
        this.allocatedBerth = allocatedBerth;
    }

    // Getter method for berth preference
    public String getBerthPreference() {
        // Return the berth preference
        return berthPreference;
    }

    // Override toString method to provide a string representation of the passenger
    @Override
    public String toString() {
        // Return formatted string with passenger details
        return "\n Name : " + name +
                "\n Age : " + age +
                "\n Gender : " + gender +
                "\n Ticket Id : " + ticketId +
                "\n Status : " + status +
                "\n Allocated Berth : " + allocatedBerth;
    }
}
