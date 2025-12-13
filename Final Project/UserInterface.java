import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.Gson;


public class UserInterface {

private Meteorite[] meteorites;
private Scanner scan = new Scanner(System.in);
private static String DATA_FILE = "meteorites.dat";


/**
 * go method is the main loop of the program
 * main is in myMeteoror class
 */
public void go() {
    //loadFromBinaryFile();

    int choice;
    do {
        showMenue();
        choice = readInt("Enter your choice: ");
        handleUserChoice(choice);
    } while (choice != 0);
    System.out.println("Exiting program. Goodbye!");
}


/**
 * readInt method reads an integer from user input
 */
private int readInt(String prompt){
    while (true) {
        System.out.print(prompt + " ");
        String line = scan.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}

/**
 * showMenue method displays the menu options
 */
private void showMenue(){
    System.out.println();
    System.out.println("Welcome to the NASA Meteorite Database.");
    System.out.println();
    System.out.println("Menu Options:");
    System.out.println("0. Exit");
    System.out.println("1. Load meteorite data from JSON file");
    System.out.println("2. Display all meteorites");
    System.out.println("3. Export meteorite data to binary file");
    System.out.println("4. Search meteorite by name");
    System.out.println("5. Search a meteorite by ID");
    System.out.println("6. List the largest meteorites");
    System.out.println("7. List meteorites the most recent metorite by year");
    System.out.println("8. List meteorites by classes");
    System.out.println("Please enter your choice (0-8): ");
}

/**
 * 
 * @param choice
 */
private void handleUserChoice(int choice){
    if (choice == 1) {
        loadFromJsonFile();
    } else if (choice == 2) {
        //displayAllMeteorites();
    } else if (choice == 3) {
        //saveToBinaryFile();
    } else if (choice == 4) {
        //searchMeteoriteByName();
    } else if (choice == 5) {
        //searchMeteoriteByID();
    } else if (choice == 6) {
        //listLargestMeteorites();
    } else if (choice == 7) {
        //listMostRecentMeteorites();
    } else if (choice == 8) {
        //listMeteoritesByClass();
    } else if (choice == 0) {
        // Exit option handled in main loop
    } else {
        System.out.println("Invalid choice. Please try again.");
    }
}

/**
 * Option 1
 * https://www.geeksforgeeks.org/dsa/ternary-operator-in-programming/
 * 
 */
 private void loadFromJsonFile() {
    System.out.println("Enter the path to the JSON file (or press Enter to use default 'NASA_Meteorite.json'):");
    String fileName = scan.nextLine().trim();

    if(fileName.isEmpty()){
        fileName = "NASA_Meteorite.json";
    }
    try {
    String json = Files.readString(Path.of(fileName));
    Gson gson = new Gson();
    meteorites = gson.fromJson(json, Meteorite[].class);

    int count = (meteorites != null) ? meteorites.length : 0;
    System.out.println(count + " meteorites loaded from " + fileName);
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
 }

/**
 * Links used:
 * https://www.geeksforgeeks.org/java/java-nio-file-package/
 */
}