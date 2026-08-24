import java.util.ArrayList;
import java.util.Scanner;

public class AccommodationManager {
    private ArrayList<StudentAccommodation> bookings = new ArrayList<>();
    // Advanced arrays - 2D array (Learning Unit 1)
    private String[][] blocks = {{"A-Block", "B-Block", "C-Block"}, {"101", "102", "103", "104", "105"}};
    Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n--- STUDENT ACCOMMODATION SYSTEM (Section B) ---");
            System.out.println("(1) Book Accommodation");
            System.out.println("(2) View Report - Console Report");
            System.out.println("(3) Back to Main Menu");
            System.out.print("Choose: ");
            String c = sc.nextLine();
            if (c.equals("1")) captureBooking();
            else if (c.equals("2")) printReport();
            else if (c.equals("3")) break;
        }
    }

    private void captureBooking() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Block (A-Block/B-Block): ");
        String block = sc.nextLine();
        System.out.print("Enter Room Number: ");
        int room = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        bookings.add(new StudentAccommodation(block, room, price, name, id));
        System.out.println("Booking saved successfully!!!");
    }

    private void printReport() {
        System.out.println("\n===== ACCOMMODATION REPORT - 2026 =====");
        System.out.println("Available Blocks (using 2D Array):");
        // Loop through 2D array
        for (int i = 0; i < blocks[0].length; i++) {
            System.out.print(blocks[0][i] + " ");
        }
        System.out.println("\n-------------------------------");

        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i+1) + ". " + bookings.get(i).getReport());
            }
        }
        System.out.println("Total Bookings: " + bookings.size());
    }
}