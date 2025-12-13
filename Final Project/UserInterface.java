import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.Gson;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


public class UserInterface {

private Meteorite[] meteorites;
private Scanner scan = new Scanner(System.in);
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

/**
 * loadFromBinaryFile method loads meteorite data from a binary file
 */
private void loadFromBinaryFile() {
    File file = new File(DATA_FILE);
    if (!file.exists()) {
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
        meteorites = (Meteorite[]) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading from binary file: " + e.getMessage());
    }
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
 * hasData method checks if meteorite data is loaded
 */
private boolean hasData() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return false;
    }
    return true;
}

/**
 * readString method reads a string from user input
 */
private String readString(String prompt){
    System.out.print(prompt + " ");
    return scan.nextLine().trim();
}

/**
 * safeParseInt method safely parses an integer from a string
 */
private int safeParseInt(String s){
    try {
        return Integer.parseInt(s.trim());
    } catch (Exception e) {
        return -1; // or handle the error as needed
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
        displayAllMeteorites();
    } else if (choice == 3) {
        saveToBinaryFile();
    } else if (choice == 4) {
        searchMeteoriteByName();
    } else if (choice == 5) {
        searchMeteoriteByID();
    } else if (choice == 6) {
        listLargestMeteorites();
    } else if (choice == 7) {
        listMostRecentMeteorites();
    } else if (choice == 8) {
        listMeteoritesByClass();
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
 * Option 2
 * 
 */
private void displayAllMeteorites(){
if (meteorites == null || meteorites.length == 0) {
    System.out.println("No meteorite data available. Please load data first.");
    return;
 }
    for (Meteorite m : meteorites) {
        System.out.println(m.toString());
    }
}

//Option 3
private void saveToBinaryFile() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available to save. Please load data first.");
        return;
    }
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
        oos.writeObject(meteorites);
        System.out.println("Meteorite data saved to " + DATA_FILE);
    } catch (IOException e) {
        System.out.println("Error saving to binary file: " + e.getMessage());
    }
}

//option 4
private void searchMeteoriteByName(){
    if (!hasData())
        return;

    String name = readString("Enter the name of the meteorite to search for: ");
    for (Meteorite m : meteorites) {
        if (m != null && m.getName() != null && m.getName().equalsIgnoreCase(name)) {
            System.out.println(m.display());
            return;
        }
    }
}

//option 5
private void searchMeteoriteByID(){
    if (!hasData())
        return;

    String id = readString("Enter the ID of the meteorite to search for: ");
    for (Meteorite m : meteorites) {
        if (m != null && m.getID() != null && m.getID().equals(id)) {
            System.out.println(m.display());
            return;
        }
    }
}

//option 6
/**
 * https://www.geeksforgeeks.org/java/how-to-override-compareto-method-in-java/
 * 
 */
private void listLargestMeteorites(){
    if(!hasData())
        return;
    int n = readInt("Enter the number of largest meteorites to list: ");
    if (n <= 0){
        System.out.println("Please enter a positive integer.");
        return;
    }


    List<Meteorite> meteoriteList = new ArrayList<>();
    for (Meteorite m : meteorites) {
        if (m == null) continue;

        double mass = m.getMassDouble();
        if (mass > 0) {
            meteoriteList.add(m);
        }
    }
    if (meteoriteList.isEmpty()) {
        System.out.println("No meteorites with valid mass data found.");
        return;
    }

    meteoriteList.sort(new Comparator<Meteorite>() {
        @Override
        public int compare(Meteorite m1, Meteorite m2) {
            return Double.compare(m2.getMassDouble(), m1.getMassDouble());
        }
    });

    int count = Math.min(n, meteoriteList.size());
    for (int i = 0; i< count; i++){
        System.out.println(meteoriteList.get(i).display());
    }
    
}

//option 7
private void listMostRecentMeteorites(){
    if(!hasData())
        return;
    int n = readInt("Enter the number of most recent meteorites to list: ");
    if (n <= 0){
        System.out.println("Please enter a positive integer.");
        return;
    }

    
    List<Meteorite> meteoriteList = new ArrayList<>();
    for (Meteorite m : meteorites) {
        if (m == null) continue;

        int year = m.getYearInt();
        if (year > 0) {
            meteoriteList.add(m);
        }
    }
    if (meteoriteList.isEmpty()) {
        System.out.println("No meteorites with valid mass data found.");
        return;
    }

    meteoriteList.sort(new Comparator<Meteorite>() {
        @Override
        public int compare(Meteorite m1, Meteorite m2) {
            return Integer.compare(m2.getYearInt(), m1.getYearInt());
        }
    });

    int count = Math.min(n, meteoriteList.size());
    for (int i = 0; i< count; i++){
        System.out.println(meteoriteList.get(i).display());
    }
}


//option 8
private void listMeteoritesByClass(){
    if(!hasData())
        return;
    String recclass = readString("Enter the meteorite class to list: ");

    List<Meteorite> meteoriteList = new ArrayList<>();
    for (Meteorite m : meteorites) {
        if (m == null) continue;

        if (m.getRecclass() != null && m.getRecclass().equalsIgnoreCase(recclass)) {
            meteoriteList.add(m);
        }
    }
    if (meteoriteList.isEmpty()) {
        System.out.println("No meteorites found for class: " + recclass);
        return;
    }

    for (Meteorite m : meteoriteList) {
        System.out.println(m.display());
    }
}
}

/**
 * Links used:
 * https://www.geeksforgeeks.org/java/java-nio-file-package/
 */
