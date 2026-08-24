import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    public ArrayList<SeriesModel> seriesList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // 1.2 + 1.3 + 1.4
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("****************************");

        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        String age = getValidAgeInput();

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    // Method to validate age restriction 2 - 18 and numbers only
    private String getValidAgeInput() {
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String input = scanner.nextLine();
            try {
                int age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) {
                    return input;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }
    }

    // Used by menu and by unit tests
    public SeriesModel SearchSeries(String searchId) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(searchId)) {
                return s;
            }
        }
        return null;
    }

    // 1.5 - Search
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        SeriesModel found = SearchSeries(id);

        if (found != null) {
            System.out.println("--------------------------------------------");
            System.out.println("SERIES ID: " + found.SeriesId);
            System.out.println("SERIES NAME: " + found.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + found.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + found.SeriesNumberOfEpisodes);
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // 1.6 - Update
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        SeriesModel found = SearchSeries(id);

        if (found != null) {
            System.out.print("Enter the series name: ");
            String newName = scanner.nextLine();
            found.SeriesName = newName;

            String newAge = getValidAgeInput();
            found.SeriesAge = newAge;

            System.out.print("Enter the number of episodes: ");
            String newEpisodes = scanner.nextLine();
            found.SeriesNumberOfEpisodes = newEpisodes;

            System.out.println("Series with Series Id: " + id + " WAS updated!");
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // For Unit Test: TestUpdateSeries()
    public boolean UpdateSeries(String id, String newName, String newAge, String newEpisodes) {
        SeriesModel found = SearchSeries(id);
        if (found != null) {
            found.SeriesName = newName;
            found.SeriesAge = newAge;
            found.SeriesNumberOfEpisodes = newEpisodes;
            return true;
        }
        return false;
    }

    // 1.7 - Delete
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        SeriesModel found = SearchSeries(id);

        if (found != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete.\n");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(found);
                System.out.println("--------------------------------------------");
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
                System.out.println("--------------------------------------------");
            }
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // For Unit Test: TestDeleteSeries()
    public boolean DeleteSeries(String id) {
        SeriesModel found = SearchSeries(id);
        if (found != null) {
            seriesList.remove(found);
            return true;
        }
        return false;
    }

    // 1.8 - Report - 2025
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series data available.");
            return;
        }
        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("Series " + count);
            System.out.println("--------------------------------------------");
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            System.out.println("--------------------------------------------");
            count++;
        }
    }

    // Exit
    public void ExitSeriesApplication() {
        System.out.println("Exiting Application...");
        System.exit(0);
    }

    // For Unit Test: TestSeriesAgeRestriction
    public boolean isAgeValid(String age) {
        try {
            int a = Integer.parseInt(age);
            return a >= 2 && a <= 18;
        } catch (Exception e) {
            return false;
        }
    }
}