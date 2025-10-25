
//this will help you on project D

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;


public class Player {
    // construct, getter and setter, method
    // fields for the code
    private String name;
    private int health;
    private int maxDamage;

    // Player user = new Player( "Bob", 20, 100);
    // Player (name: String, maxDamage: int) set for constructor
    
    public Player(String name, int maxDamage) {
        this.name = name; // Alien
        this.health = 100; // set for integer need to be "initial health for 100"
        this.maxDamage = maxDamage; // come from the constructor "can give a maximum damage of 5 points."

    }

    // Methods from pdf
    /**
     * 
     * @return the players name
     */
    // +getName(): String
    public String getName() {
        return name;
    }

    // +setName (name: String)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param health the new health of the player
     */
    // + setHealth(health: int)
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return current health of the player
     */
    // +getHealth(): int
    public int getHealth() {
        return health;
    }

    // +setMaxDamage(maxDamage:int)
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    // +getMaxDamage() int
    public int getMaxDamage() {
        return maxDamage;
    }

    // +dealDamage (other: Player)
    // The Player class’s dealDamage method should apply damage to the Player object
    // based on a random number between 0 and the maxDamage from the other Player
    // object.
    /**
     * 
     * @param other
     */
    public void dealDamage(Player other) {
        Random ran = new Random();
        int damage = ran.nextInt(this.maxDamage + 1);// between 0 and the maxDamage
        int newHealth = other.getHealth() - damage; // subtract the damage from the health
        other.setHealth(Math.max(newHealth, 0)); // set the health to the new value or 0 if it's negative
        System.out.println(this.name + " deals " + damage + " damage to " + other.getName() + ".");
    }

    // toSting(): String
    // The Player class’s toString method should Override the default toString
    // method to create a String that contains the Player object’s name and current
    // Health Points (HP)
    @Override
    public String toString() {
        return name + " HP " + health;
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String userinput;
        String oneName;
        int oneMaxDamage;
        String twoName;
        int twoMaxDamage;
        int oneHealth;
        int twoHealth;
        String winner = "No winner yet";

    
        // in main have One Player instance has name “One Punch Man”, initial health of
        // 100, and can
        // give a maximum damage of 20 points.
        // have the two character for alien and player
        Player onePunchMan = new Player("One Punch Man", 20);
        Player alien = new Player("Alien", 5);

        System.out.println(onePunchMan);
        System.out.println(alien);
        scnr.nextLine(); // wait for user input

        // while loop for the game to run until one of the player is dead
        while(onePunchMan.getHealth() > 0 && alien.getHealth() > 0) {
        onePunchMan.dealDamage(alien);
        if(alien.getHealth() <= 0) break;
        alien.dealDamage(onePunchMan);

        System.out.println(onePunchMan);
        System.out.println(alien);
        scnr.nextLine(); // wait for user input
        }
    

        // winner
        if (onePunchMan.getHealth() > 0){
            System.out.println("The winner is " + onePunchMan.getName());
        }
        else {
            System.out.println("The winner is " + alien.getName());
        
    }


} 
}