import java.io.FileInputStream;
import java.util.*.*;
import com.google.gson.JsonObject;

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
    
public void go() {
    loadFromBinaryFile();
    int choice;
    do {
        displayMenu();
        choice = readInt("Enter your choice: ");
        handleUserChoice(choice);
    } while (choice != 0);
    System.out.println("Exiting program. Goodbye!");
}

/**
 * Copy and past from pdf here "The UserInterface class should control all the input/output.  Display a menu with the 
following options:"
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
private void handleUserChoice(int choice){
    if (choice == 0) {
        System.out.println("Exiting program. Goodbye!");
    } else if (choice == 1) {
        loadFromJsonFile();
    } else if (choice == 2) {
        displayAllMeteorites();
    } else if (choice == 3) {
        exportToBinaryFile();
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

//Option 1 import from json file
private void loadFromJsonFile() {
    System.out.println("Loading meteorite data from JSON file...");
    Sring fileName = in.nextLine().trim();
    if (fileName.isEmpty()){
        fileName = "data/NASA_Metorite.json";
    }
    try {
        String json = Files.readString(Path.of(fileName));
        Gson gson = new Gson();
        meteorites = gson.fromJson(json, Meteorite[].class);
        System.out.println((metorites == null ? 0 : meteorites.length) + " meteorites loaded from " + fileName);{
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
        }
    
}

//Option 2 display all meteorites
private void displayAllMeteorites() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    for (Meteorite meteorite : meteorites) {
        System.out.println(meteorite.display());
        System.out.println("------------------------------");
    }
}

//Option 3 save to binary file
private void saveToBinaryFile() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available to save.");
        return;
    }
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
        oos.writeObject(meteorites);
        System.out.println("Meteorite data saved to " + DATA_FILE);
    } catch (IOException e) {
        System.out.println("Error saving to binary file: " + e.getMessage());
    }
}
//Load from binary file
private void loadFromBinaryFile() {
    File file = new File(Binary_FILE);
    if (!file.exists()) {
        // No error message if file not found, as expected on first run
        return;
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
        meteorites = (Meteorite[]) ois.readObject();
        System.out.println("Meteorite data loaded from " + DATA_FILE);
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading from binary file: " + e.getMessage());
    }
}
//Option 4 search meteorite by name
private void searchMeteoriteByName() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    String name = readString("Enter the name of the meteorite to search: ");
    boolean found = false;
    for (Meteorite meteorite : meteorites) {
        if (meteorite.getName().equalsIgnoreCase(name)) {
            System.out.println("Meteorite found:");
            System.out.println(meteorite.display());
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("No meteorite found with the name: " + name);
    }
}

//Option 5 search meteorite by ID
private void searchByID() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    int id = readInt("Enter the ID of the meteorite to search: ");
    boolean found = false;
    for (Meteorite meteorite : meteorites) {
        if (meteorite.getId() != null && meteorite.getId() == id) {
            System.out.println("Meteorite found:");
            System.out.println(meteorite.display());
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("No meteorite found with the ID: " + id);
    }
}

//Option 6 list largest meteorites
private void listLargestMeteorites() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    
    int count = readInt (" How many of the largest meteorites to list? ");
    List<Meteorite> meteoriteList = new ArrayList<>();
    for (metorite meteorite : meteorites) {
        meteoriteList.add(meteorite);
    }   
}

List <Metorites> top = new ArrayList<>();
int added = 0;
for (Meteorite meteorite : meteoriteList) {
    if (meteorite.getMass() != null) {
        top.add(meteorite);
        added++;
        if (added >= count) {
            break;
        }
    }
}
for metorite : top) {
    System.out.println(meteorite.display());
}
}
//Option 7 list most recent meteorites
private void listMostRecentMeteorites() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    
}

//Option 8 list meteorites by class
private void listMeteoritesByClass() {
    if (meteorites == null || meteorites.length == 0) {
        System.out.println("No meteorite data available. Please load data first.");
        return;
    }
    Map<String, List<Meteorite>> classMap = new HashMap<>();
    for (Meteorite meteorite : meteorites) {
        String recclass = meteorite.getRecclass();
        classMap.putIfAbsent(recclass, new ArrayList<>());
        classMap.get(recclass).add(meteorite);
    }

    // Help
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }
