// Import necessary Java utilities
import java.util.*;

// BookingSystem class to manage railway ticket bookings, cancellations, and displays
public class BookingSystem {
    // List to store available confirmed berths (l=lower, m=middle, u=upper)
    private final List<String> availableBerth = new ArrayList<>() {
        {
            // Add 21 lower berths
            for (int i = 0; i < 21; i++)
                add("l");
            // Add 21 middle berths
            for (int i = 0; i < 21; i++)
                add("m");
            // Add 21 upper berths
            for (int i = 0; i < 21; i++)
                add("u");
        }
    };
    // List to store confirmed passengers
    private final List<Passenger> confirmPassengers = new ArrayList<>();
    // Queue for RAC passengers
    private final Queue<Passenger> racQueue = new LinkedList<>();
    // Queue for waiting list passengers
    private final Queue<Passenger> waitingList = new LinkedList<>();

    // Static counter for generating unique ticket IDs
    static int ticketCounter = 1;

    // Method to book a ticket based on passenger details
    public void bookTicket(String name, int age, String gender, String berthPreference) {
        // Generate a unique ticket ID
        int ticketId = ticketCounter++;
        // Declare passenger variable
        Passenger passenger;
        // Check if confirmed berths are available
        if (!availableBerth.isEmpty()) {
            // Allocate berth considering priority rules
            String allocatedBerth = allocatedBerth(age, gender, berthPreference, availableBerth);
            // Create confirmed passenger
            passenger = new Passenger(name, age, gender, berthPreference, ticketId, "confirmed");
            // Set the allocated berth
            passenger.setAllocatedBerth(allocatedBerth);
            // Remove the allocated berth from available list
            availableBerth.remove(allocatedBerth);
            // Add to confirmed passengers
            confirmPassengers.add(passenger);
            // Print confirmation message
            System.out.println("Your ticket is confirmed" + passenger);
        // If no confirmed berths, check RAC availability
        } else if (racQueue.size() < 18) {
            // Create RAC passenger
            passenger = new Passenger(name, age, gender, berthPreference, ticketId, "rac");
            // Allocate side-lower berth for RAC
            passenger.setAllocatedBerth("sl"); // side-lower berth
            // Add to RAC queue
            racQueue.offer(passenger);
            // Print RAC message
            System.out.println("Your ticket in RAC" + passenger);
        // If RAC full, check waiting list
        } else if (waitingList.size() < 10) {
            // Create waiting list passenger
            passenger = new Passenger(name, age, gender, berthPreference, ticketId, "waiting");
            // Add to waiting list
            waitingList.offer(passenger);
            // Print waiting list message
            System.out.println("Your ticket in waiting list" + passenger);
        // If all full, deny booking
        } else {
            // Print no tickets available
            System.out.println("No tickets available");
        }
    }

    // Method to allocate berth based on age, gender, preference, and availability
    public String allocatedBerth(int age, String gender, String berthPreference, List<String> available) {
        // If age < 5, no berth allocation
        if (age < 5) {
            return "";
        // Priority for >60 or female: try lower berth
        } else if ((age > 60 || gender.equalsIgnoreCase("f")) && available.contains("l")) {
            return "l";
        // If preferred berth is available, assign it
        } else if (available.contains(berthPreference)) {
            return berthPreference;
        // Otherwise, assign any available berth
        } else if (!available.isEmpty()) {
            return available.get(0); // any available
        // If no berths available, return empty
        } else {
            return "";
        }
    }

    // Method to cancel a ticket by ticket ID
    public String cancelTicket(int ticketId) {
        // Search for the ticket in confirmed passengers
        Optional<Passenger> p = confirmPassengers.stream().filter(x -> x.getTicketId() == ticketId).findFirst();

        // If found in confirmed
        if (p.isPresent()) {
            // Add the berth back to available
            availableBerth.add(p.get().getAllocatedBerth());
            // Remove from confirmed
            confirmPassengers.remove(p.get());

            // Promote RAC to confirmed if available
            if (!racQueue.isEmpty()) {
                // Get first RAC passenger
                Passenger racPassenger = racQueue.poll();
                // Allocate berth for promotion
                String berth = allocatedBerth(racPassenger.getAge(), racPassenger.getGender(),
                        racPassenger.getBerthPreference(), availableBerth);
                // Set allocated berth
                racPassenger.setAllocatedBerth(berth);
                // Add to confirmed
                confirmPassengers.add(racPassenger);
            }
            // Promote waiting to RAC if available
            if (!waitingList.isEmpty()) {
                // Get first waiting passenger
                Passenger waitingPassenger = waitingList.poll();
                // Set RAC berth
                waitingPassenger.setAllocatedBerth("sl");
                // Add to RAC queue
                racQueue.offer(waitingPassenger);
            }

            // Return success message
            return "Ticket cancelled";
        }

        // Search in RAC queue
        p = racQueue.stream().filter(x -> x.getTicketId() == ticketId).findFirst();
        // If found in RAC
        if (p.isPresent()) {
            // Remove from RAC
            racQueue.remove(p.get());
            // Return success
            return "Ticket cancelled";
        }

        // Search in waiting list
        p = waitingList.stream().filter(x -> x.getTicketId() == ticketId).findFirst();
        // If found in waiting
        if (p.isPresent()) {
            // Remove from waiting
            waitingList.remove(p.get());
            // Return success
            return "Ticket cancelled";
        }

        // If not found anywhere
        return "Ticket not found";
    }

    // Method to print available tickets by category
    public void printAvailableTickets() {
        // Print available confirmed berths
        System.out.println("Available confirmed berths: " + availableBerth.size());
        // Print available RAC berths
        System.out.println("Available RAC berths: " + (18 - racQueue.size()));
        // Print available waiting list spots
        System.out.println("Available waiting list spots: " + (10 - waitingList.size()));
        // Print total available
        System.out.println("Total available: " + (availableBerth.size() + (18 - racQueue.size()) + (10 - waitingList.size())));
    }

    // Method to print all booked tickets
    public void printBookedTickets() {
        // Print header
        System.out.println("Booked tickets : ");
        // Print confirmed passengers
        for (Passenger details : confirmPassengers) {
            System.out.println(details);
        }
        // Print RAC passengers
        for (Passenger details : racQueue) {
            System.out.println(details);
        }
        // Print waiting list passengers
        for (Passenger details : waitingList) {
            System.out.println(details);
        }
        // Calculate total booked
        int total = confirmPassengers.size() + racQueue.size() + waitingList.size();
        // Print total
        System.out.println("Total number of booked tickets: " + total);
    }

}
