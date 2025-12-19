// Import necessary Java utilities
import java.util.*;

// Main class to run the railway ticket booking system
public class Main {
    // Main method, entry point of the program
    public static void main(String[] arg) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create an instance of BookingSystem
        BookingSystem ticketSystem = new BookingSystem();
        // Infinite loop for menu-driven interface
        while (true) {

            // Print menu header
            System.out.println("========================");
            // Print menu title
            System.out.println("Select any option : ");
            // Print menu separator
            System.out.println("========================");
            // Print option 1
            System.out.println("1. Book your tickets");
            // Print option 2
            System.out.println("2. Cancel your tickets");
            // Print option 3
            System.out.println("3. View available tickets");
            // Print option 4
            System.out.println("4. Print Available tickets");
            // Print option 5
            System.out.println("5. Exit");

            // Read user's choice
            int choice = scanner.nextInt();
            // Switch based on choice
            switch (choice) {
                // Case for booking ticket
                case 1:
                    // Prompt for name
                    System.out.println("Enter your name :");
                    // Read name
                    String name = scanner.next();
                    // Prompt for age
                    System.out.println("Enter your age :");
                    // Read age
                    int age = scanner.nextInt();
                    // Prompt for gender
                    System.out.println("Enter your gender (m/f)");
                    // Read gender
                    String gender = scanner.next();
                    // Prompt for berth preference
                    System.out.println("Enter your Berth preference");
                    // Read berth preference
                    String berthPreference = scanner.next();
                    // Call bookTicket method
                    ticketSystem.bookTicket(name, age, gender, berthPreference);
                    // Break from switch
                    break;
                // Case for cancelling ticket
                case 2:
                    // Prompt for ticket ID
                    System.out.println("Enter your ticket");
                    // Read ticket ID
                    int ticketId = scanner.nextInt();
                    // Call cancelTicket method
                    ticketSystem.cancelTicket(ticketId);
                    // Break from switch
                    break;
                // Case for viewing booked tickets
                case 3:
                    // Call printBookedTickets method
                    ticketSystem.printBookedTickets();
                    // Break from switch
                    break;
                // Case for viewing available tickets
                case 4:
                    // Call printAvailableTickets method
                    ticketSystem.printAvailableTickets();
                    // Break from switch
                    break;
                // Case for exit
                case 5:
                    // Print exit message
                    System.out.println("exiting....");
                    // Close scanner
                    scanner.close();
                // Default case for invalid choice
                default:
                    // Print invalid choice message
                    System.out.println("Invalid choice...");
                    // Break from switch
                    break;
            }
        }
    }
}
