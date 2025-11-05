
//Some of this was code copy and pasted from lab taught before like the one for mapping and the actor and monster class
import java.util.Scanner;
import java.util.Random;

//https://www.youtube.com/watch?v=om59cwR7psI&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq
//follow UML diagram
//My Extra feature is the gold system (Rose mentioned in class) 

public class TheCataComb {

    /**
     *  The Actor class represents a character in the game, either a hero or a monster.
     * It contains attributes such as name, health, maxDamage, and actorType. The
     */
    public class Actor {

        // protected b/c it is a subclass of the player class
        protected String name;
        protected int health; // 100
        protected int maxDamage; // 5
        protected String actorType;

        public Actor(String name, int maxDamage, int health, String actorType) {
            this.name = name; // Alien
            this.health = health; // set for integer need to be "initial health for 100"
            this.actorType = actorType; // 0
            this.maxDamage = maxDamage; // come from the constructor "can give a maximum damage of 5 points."
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMaxDamage() {
            return maxDamage;
        }

        public void setMaxDamage(int maxDamage) {
            this.maxDamage = maxDamage;
        }

    
        public int dealDamage();

    }

    /**
     * The Hero class represents the player character in the game. It inherits from the actor class
     */
    public class Hero extends Actor {
        private Random ran = new Random();
        private int gold; // Declare the gold variable

        // Constructor for hero class
        public Hero(String name) {
            super(name, 5, 100, "Hero"); // name, maxDamage, health, actorType
            ran = new Random();
            gold = 0; // Initialize gold to 0
        }

        /**
         * The dealDamage method generates a random damage value between 1 and maxDamage
         * @return the damage dealt by the hero
         */

        @Override
        public int dealDamage() {
            return ran.nextInt(10) + 1; // Random damage between 1 and maxDamage
        }

        public void addGold(int amount) {
            this.gold += amount; // Set the gold variable
        }

        // Getter for gold
        public int getGold() {
            return gold;
        }
    }

    /**
     * The Monster class represents the enemy character in the game. It inherits from the actor class
     */
    public class Monster extends Actor {
        private Random ran; // Declare the Random variable

        // Constructor for monster class
        public Monster(String name) {
            super(name, 5, 25, "Monster"); // name, maxDamage, health, actorType
            ran = new Random(); // Initialize the Random variable
        }

        /**
         * The dealDamage method generates a random damage value between 1 and maxDamage
         * @return the damage dealt by the monster
         */
        @Override
        public int dealDamage() {
            return ran.nextInt(5) + 1; // Random damage between 1 and maxDamage
        }
    }


    /**
     * The main method initializes the game, creates the catacomb, and handles user input for movement and actions.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();

        int width; // width of the catacomb
        int goldX;
        int goldY;
        String heroName;
        int goldPiles;
        boolean playing;

        // Create the catacomb
        System.out.println("Welcome to the Catacomb!");
        scan.nextLine();

        System.out.println("What is the Hero's name: ");
        heroName = scan.nextLine();

        // Create a Hero instance
        TheCataComb game = new TheCataComb(); // Create an instance of TheCataComb
        Hero player = game.new Hero(heroName); // Use the instance to create a Hero

        System.out.println("Enter the width of the catacomb (5-10): ");
        width = scan.nextInt();

        if (width < 5 || width > 10) {
            System.out.println("Invalid width. Please enter a number between 5 and 10.");
            return; // Exit the program if the width is invalid
        }

        // Initialize the catacomb array after getting the width
        char[][] catacomb = new char[width][width];
        // Reuse the existing catacomb variable
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                catacomb[i][j] = '-'; // Fill the grid with '-' to represent empty spaces
            }
        }

        // Place the hero in the top left corner of the catacomb
        int playerRow = 0; // Initialize player's row position
        int playerCol = 0; // Initialize player's column position
        catacomb[playerRow][playerCol] = 'H'; // Place the hero in the grid

        // Place the hero in the center of the catacomb
        int totalRooms = width * width;
        int numOfMonsters = totalRooms / 6; // 1 monster for every 4 rooms
        int monsterPlaced = 0;

        while (monsterPlaced < numOfMonsters) {
            int monsterX = ran.nextInt(width); // Random x-coordinate for the monster
            int monsterY = ran.nextInt(width); // Random y-coordinate for the monster

            // Check if the position is empty before placing the monster
            if (catacomb[monsterX][monsterY] == '-' && (monsterX != 0 || monsterY != 0)) {
                catacomb[monsterX][monsterY] = 'M'; // Place the monster in the grid
                monsterPlaced++;
            }
        }

        // Place the gold in the catacomb
        goldPiles = width;
        int goldPlaced = 0; // Number of gold pieces placed in the catacomb

        while (goldPlaced < goldPiles) {
            goldX = ran.nextInt(width); // Random x-coordinate for the gold
            goldY = ran.nextInt(width); // Random y-coordinate for the gold

            // Check if the position is empty before placing the gold
            if (catacomb[goldX][goldY] == '-') {
                catacomb[goldX][goldY] = 'G'; // Place the gold in the grid
                goldPlaced++;
            }
        }

        
        // Move the player in the catacomb
        scan.nextLine();
        playing = true; // Set playing to true to enter the game loop

        while (playing) {
            // Show hero's current position and the catacomb
            System.out.println(player.getName() + " HP: " + player.health + " | Gold: " + player.getGold());
            System.out.println("You are at (" + playerRow + ", " + playerCol + ")");
            System.out.println("Which direction do you want to go? (N, S, E, W): ");
            String direction = scan.nextLine().toUpperCase(); // Convert input to uppercase

            int newRow = playerRow; // Initialize newRow to the current row
            int newCol = playerCol; // Initialize newCol to the current column

            // based on input find new position
            if (direction.equals("N")) {
                newRow--; // Move up
            } else if (direction.equals("S")) {
                newRow++; // Move down
            } else if (direction.equals("E")) {
                newCol++; // Move right
            } else if (direction.equals("W")) {
                newCol--; // Move left
            } else {
                System.out.println("Invalid direction. Please enter N, S, E, or W.");
                continue; // Skip the rest of the loop and ask for input again
            }

            if (newRow < 0 || newRow >= width || newCol < 0 || newCol >= width) {
                System.out.println("You can't move outside the catacomb. Try again.");
                continue; // Skip the rest of the loop and ask for input again
            }

            // Move Hero
            catacomb[playerRow][playerCol] = '-'; // Clear the old position
            playerRow = newRow; // Update the player's row position
            playerCol = newCol; // Update the player's column position
            catacomb[playerRow][playerCol] = 'H';

            //Smell the monster
            System.out.println(player.getName() + " HP: " + player.health + " | Gold: " + player.getGold());
            System.out.println("You are at (" + playerRow + ", " + playerCol + ")");

            int nearbyMonsters = 0; // Count of nearby monsters
            if (playerRow > 0 && catacomb[playerRow - 1][playerCol] == 'M') nearbyMonsters++; // Check North
            if (playerRow < width - 1 && catacomb[playerRow + 1][playerCol] == 'M') nearbyMonsters++; // Check South
            if (playerCol > 0 && catacomb[playerRow][playerCol - 1] == 'M') nearbyMonsters++; // Check West
            if (playerCol < width - 1 && catacomb[playerRow][playerCol + 1] == 'M') nearbyMonsters++; // Check East

            System.out.println("You smell " + nearbyMonsters + " monster(s) nearby!");
        

            // Hero loses 2 HP for moving
            player.health -= 2; // Decrease health by 2 for moving
            if (player.health <= 0) {
                System.out.println("You have died. Game over.");
                playing = false;
                break;
            }

            // In new room with gold
            if (catacomb[playerRow][playerCol] == 'G') {
                System.out.println("You found gold!");
                catacomb[playerRow][playerCol] = '-'; // Remove the gold from the grid
                player.addGold(1); // Increment the player's gold count
                System.out.println("You now have " + player.getGold() + " gold.");
            } else if (catacomb[playerRow][playerCol] == 'M') { // In new room with monster
                System.out.println("You encountered a monster!");
                Monster monster = game.new Monster("Monster"); // Create a new monster instance
                int damage = monster.dealDamage(); // Get the damage from the monster
                player.health -= damage; // Decrease player's health by monster's damage
                System.out.println("The monster dealt " + damage + " damage to you.");

                // Battle with the monster
                while (player.health > 0 && monster.health > 0) {
                    // Player's turn to attack
                    int playerDamage = player.dealDamage(); // Get the damage from the player
                    monster.health -= playerDamage; // Decrease monster's health by player's damage
                    System.out.println(player.getName() + " dealt " + playerDamage + " damage to the monster.");

                    // Check if the monster is defeated
                    if (monster.health <= 0) {
                        System.out.println("You defeated the monster!");
                        break; // Exit the loop if the monster is defeated
                    }

                    // Monster's turn to attack
                    int monsterDamage = monster.dealDamage(); // Get the damage from the monster
                    player.health -= monsterDamage; // Decrease player's health by monster's damage
                    System.out.println("The monster dealt " + monsterDamage + " damage to you.");

                    // Check if the player is defeated
                    if (player.health <= 0) {
                        System.out.println("You have died. Game over.");
                        playing = false;
                        break;
                    }
                }
            } else if (catacomb[playerRow][playerCol] == '-') { // Empty room
                System.out.println("You moved to an empty room.");
            } else {
                System.out.println("Invalid move. Please try again.");
            }

            // Place hero on new spot
        catacomb[playerRow][playerCol] = 'H'; // Place the hero in the new position
        if (playerRow == width - 1 && playerCol == width - 1) {
            System.out.println("You did it! You made it to the end of the catacomb!");
            System.out.println("Final Gold: " + player.getGold());
            System.out.println("Final Health: " + player.health);
            playing = false; // End the game loop
        }

        }
        
    }
}
//AI was used for run the code to following the rubric and give me a grade for the project.
//add a feature for when no monster are around you 
// make methods so most isn't in main
//Cleaner code with helper methods
//Monster memory (remove dead monsters)
//Unique monster names
// Optional map showing rooms
// Extra game stats at the end
//Replay option
