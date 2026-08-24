import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n======================================");
            System.out.println("PROG6112 PRACTICAL ASSIGNMENT 1 - 2026");
            System.out.println("======================================");
            System.out.println("(1) Section A - TV Series Management");
            System.out.println("(2) Section B - Student Accommodation System");
            System.out.println("(3) Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                runSeriesApp();
            } else if (choice.equals("2")) {
                AccommodationManager manager = new AccommodationManager();
                manager.run();
            } else if (choice.equals("3")) {
                System.exit(0);
            }
        }
    }

    public static void runSeriesApp() {
        Scanner scanner = new Scanner(System.in);
        Series seriesApp = new Series();
        System.out.println("\nLATEST SERIES - 2026");
        System.out.println("*******************************");
        System.out.print("Enter (1) to launch menu or any other key to exit ");
        String launch = scanner.nextLine();
        if (!launch.equals("1")) return;

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": seriesApp.CaptureSeries(); break;
                case "2": seriesApp.SearchSeries(); break;
                case "3": seriesApp.UpdateSeries(); break;
                case "4": seriesApp.DeleteSeries(); break;
                case "5": seriesApp.SeriesReport(); break;
                case "6": return;
                default: System.out.println("Invalid option");
            }
            String cont = scanner.nextLine();
            if (!cont.equals("1")) break;
        }
    }
}