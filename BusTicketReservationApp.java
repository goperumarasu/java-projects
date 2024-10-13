import java.util.ArrayList;
import java.util.Scanner;
class Bus {
    private String busNumber;
    private int totalSeats;
    private int availableSeats;
    public Bus(String busNumber, int totalSeats) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
    public String getBusNumber() {
        return busNumber;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public boolean bookSeats(int seatsToBook) {
        if (seatsToBook > 0 && seatsToBook <= availableSeats) {
            availableSeats -= seatsToBook;
            return true;
        } else {
            return false;
        }
    }
    public void displayInfo() {
        System.out.println("Trip: " + busNumber);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
    }
}
class BusReservationSystem {
    private ArrayList<Bus> buses;
    public BusReservationSystem() {
        buses = new ArrayList<>();
    }
    public void addBus(Bus bus) {
        buses.add(bus);
    }
    public Bus getBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }
    public void displayAllBuses() {
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            bus.displayInfo();
            System.out.println("--------------------");
        }
    }
}
public class BusTicketReservationApp {
    public static void main(String[] args) {
        System.out.println("WELCOME TO NKG AUTOMOBILES");
        BusReservationSystem reservationSystem = new BusReservationSystem();
        Bus bus1 = new Bus("MADURAI-CHENNAI", 30);
        Bus bus2 = new Bus("MADURAI-RAMANATHAPURAM", 40);
        Bus bus3 = new Bus("MADURAI-COIMBATORE", 40);
        Bus bus4 = new Bus("MADURAI-TRICHY", 40);
        Bus bus5 = new Bus("MADURAI-BANGALORE", 40);
        Bus bus6 = new Bus("MADURAI-HYDERABAD", 40);
        Bus bus7 = new Bus("MADURAI-MYSORE", 40);
        Bus bus8 = new Bus("MADURAI-COCHIN", 40);
        reservationSystem.addBus(bus1);
        reservationSystem.addBus(bus2);
        reservationSystem.addBus(bus3);
        reservationSystem.addBus(bus4);
        reservationSystem.addBus(bus5);
        reservationSystem.addBus(bus6);
        reservationSystem.addBus(bus7);
        reservationSystem.addBus(bus8);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display Available Buses");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reservationSystem.displayAllBuses();
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("enter your trip: ");
                    String busNumber = scanner.nextLine();
                    Bus selectedBus = reservationSystem.getBusByNumber(busNumber);
                    if (selectedBus != null) {
                        System.out.print("Enter the number of seats to book: ");
                        int seatsToBook = scanner.nextInt();
                        if (selectedBus.bookSeats(seatsToBook)) {
                            System.out.println("Seats booked successfully!");
                        } else {
                            System.out.println("Seats not available or invalid input!");
                        }
                    } else {
                        System.out.println("Invalid Bus Number!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.out.println("WISH YOU A HAPPY JOURNEY");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
