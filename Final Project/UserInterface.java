import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;

public class UserInterface {

/**
"Create a UserInterface class that has a public method named go.  The only action needed in 
the main method is to instantiate a UserInterface object and call the go method. One of 
the initialization steps is to read the data from a binary file created by a previous run of the 
program.  No error message should be displayed if the file is not found, as that is expected the 
first time the program is run."
 */

private Meteorite[] meteorites;

private Scanner scanner = new Scanner(System.in);
private static String DATA_FILE = "meteorites.dat";


/**
 * go method is the main loop of the program
 * main is in myMeteoror class
 */
public void go() {
    loadFromBinaryFile();
    int choice;
    do {
        showMenue();
        choice = readInt("Enter your choice: ");
        handleUserChoice(choice);
    } while (choice != 0);
    System.out.println("Exiting program. Goodbye!");
}


// show menue

/**
 * 
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
    if (choice == 0) {
        System.out.println("Exiting program. Goodbye!");
    } else if (choice == 1) {
        loadFromJsonFile();
    } else if (choice == 2) {
        displayAllMeteorites();
    } else if (choice == 3) {
        saveToBinaryFile();
    } else if (choice == 4) {
    loadFromBinaryFile();
    } else if (choice == 5) {
        searchMeteoriteByID();
    } else if (choice == 6) {
        ();
    } else if (choice == 7) {
        listMostRecentMeteorites();
    } else if (choice == 8) {
        listMeteoritesByClass();
    } else {
        System.out.println("Invalid choice. Please try again.");
    }
}


/**
 * Links used:
 * https://www.geeksforgeeks.org/java/java-nio-file-package/
 */
}