package tvseriesmodel;

import java.util.*;

/**
 *
 * @author ST10472846
 */
public class Series {
    
    private final String seriesId;
    String seriesName;
    int seriesNumEp;
    int seriesAge;    // stored as int for validation
    
    private static final ArrayList<Series> seriesList = new ArrayList<>();
    public static final Scanner scn = new Scanner(System.in);

    public Series(String seriesId, String seriesName, int seriesAge, int seriesNumEp) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumEp = seriesNumEp;
    }
    
    //Setters

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public void setSeriesNumEp(int seriesNumEp) {
        this.seriesNumEp = seriesNumEp;
    }
    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    //Getters
    public int getSeriesNumEp() {    
        return seriesNumEp;
    }

    //Capture Method Assisted By: Student Notes [Offline]
    // 1. Capture Series
    public static void captureSeries() {
        //Assisted By: Student Notes [Offline]
        System.out.println("""
                                            CAPTURE A NEW SERIES
                                   ***********************""");

        System.out.print("Enter Series ID: ");
        String id = scn.nextLine();//Capture Series ID

        System.out.print("Enter Series Name: ");
        String name = scn.nextLine();//Capture Series Name

        // Age restriction with validation
        //Assisted By: Student Notes [Offline]
        int age;
        while (true) {
            try {
                System.out.print("Enter Series Age Restriction (2-18): ");
                age = Integer.parseInt(scn.nextLine());//Capture Age Restriction
                
                if (age >= 2 && age <= 18) {//Checks For Correct Age Limits
                    break;
                } else {
                    System.out.println("Invalid age restriction. Please enter a number between 2 and 18.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }

        // Number of episodes
        //Assisted By: Student Notes [Offline]
        int ep;
        while (true) {
            try {
                System.out.print("Enter Number of Episodes: ");
                ep = Integer.parseInt(scn.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }

        seriesList.add(new Series(id, name, age, ep));//Save The New Series
        System.out.println("Series Details Successfully Saved!\n");
    }

    //Search Method Assisted By: (ChatGPT, 2025)
    // 2. Search Series
    public static void searchSeries() {
        System.out.print("\nEnter Series ID To Search: ");
        String id = scn.nextLine();
        
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {//Checks If Series Exists With Provided ID
                System.out.println("Series Found: \n" + s);
                return;
            }
        }
        System.out.println("No Series Found With ID " + id);
    }

    //Update Method Assisted By: (ChatGPT, 2025)
    // 3. Update Series
    public static void updateSeries() {
        System.out.print("\nEnter Series ID To Update: ");
        String id = scn.nextLine();
        
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {//Checks For Series With Provided ID
                System.out.println("Series Found: " + s);

                System.out.print("Enter New Name (leave blank to keep old): ");
                String newName = scn.nextLine();
                
                if (!newName.isEmpty()) {//Gives New Name To Series
                    s.seriesName = newName;
                }

                // Update Age with validation
                while (true) {
                    try {
                        System.out.print("Enter New Age Restriction (2-18, Leave Blank To Keep Old): ");
                        String input = scn.nextLine();
                        
                        if (!input.isEmpty()) {//Assigns New Age Limits
                            int age = Integer.parseInt(input);
                            if (age >= 2 && age <= 18) {
                                s.seriesAge = age;
                            } else {
                                System.out.println("Invalid Age. Keeping old value.");
                            }
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input. Please Enter A Number.");
                    }
                }

                // Update Episodes
                while (true) {
                    try {
                        System.out.print("Enter New Number Of Episodes (Leave Blank To Keep Old): ");
                        String input = scn.nextLine();
                        
                        if (!input.isEmpty()) {//Assigns New Number Of Episodes
                            s.seriesNumEp = Integer.parseInt(input);
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input. Please Enter A Number.");
                    }
                }

                System.out.println("Series Updated Successfully!");
                return;
            }
        }
        System.out.println("No series Found With ID " + id);
    }

    //Delete Method Assisted By: (ChatGPT, 2025)
    // 4. Delete Series
    public static void deleteSeries() {
        System.out.print("\nEnter Series ID to Delete: ");
        String id = scn.nextLine();
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {//Checks If Series Exists
                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = scn.nextLine();
                
                if (confirm.equalsIgnoreCase("Y")) {//Confirms Deletion
                    seriesList.remove(s);
                    System.out.println("Series Successfully Deleted!");
                } else {
                    System.out.println("Deletion Cancelled.");
                }
                return;
            }
        }
        System.out.println("No Series Found With ID " + id);
    }

    //Report Method Assisted By: Student Notes [Offline]
    // 5. Series Report
    public static void seriesReport() {
        System.out.println("\n=== Series Report 2025 ===");
        
        if (seriesList.isEmpty()) {//In The Case No Series Are Saved
            System.out.println("No Series Captured Yet.");
        } else {
            for (Series s : seriesList) {
                System.out.println(s);
            }
        }
    }

    //Exit Method Assisted By: Student Notes [Offline]
    // 6. Exit Application
    public static void exitSeriesApplication() {
        System.out.println("Exiting Application...\n");
        System.exit(0);//Stops The Program
    }
    
    @Override
    public String toString() {
        return "Series ID: " + seriesId + "\nName: " + seriesName +
               "\nAge Restriction: " + seriesAge + "\nEpisodes: " + seriesNumEp +
               "\n=============================\n";
    }
    
    

// ------ Helpers for Unit Testing To Bypass Scanner. (ChatGPT, 2025) ------
    
// Add directly (used in Capture test)
    public static void addSeries(Series s) {
        seriesList.add(s);
    }

// Search by ID (returns object instead of printing)
    public static Series searchSeriesById(String id) {
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

// Update series by ID
    public static boolean updateSeriesById(String id, String newName, int newAge, int newEp) {
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {
                s.seriesName = newName;
                s.seriesAge = newAge;
                s.seriesNumEp = newEp;
                return true;
            }
        }
        return false;
    }

// Delete by ID
    public static boolean deleteSeriesById(String id) {
        for (Series s : seriesList) {
            if (s.seriesId.equalsIgnoreCase(id)) {
                seriesList.remove(s);
                return true;
            }
        }
        return false;
    }

// Validate age restriction
    public static boolean isValidAge(int age) {
        return age >= 2 && age <= 18;
    }

// --- Reset between tests ---
    public static void clearSeriesList() {
        seriesList.clear();
    }
    
    
}
/*
OpenAI.2025.ChatGPT [GPT-5]. Available at 
<https://chat.openai.com/>. [Accessed 31 August 2025]

Student Notes [Offline].
[Accessed 29 August 2025]
*/
