//Ari Kinney
// 11/18/24
// 
//this will help you on project D

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

//have a class for player
public class ExtraPlayer {
    // construct, getter and setter, method
    // feilds for the code
    private String name;
    private int health;
    private int maxDamage;

    // Player user = new Player( "Bob", 20, 100);
    // Player (name: String, maxDamage: int) set for constructor
    public Player(String name, int maxDamge) {
        this.name = name; // Alien
        this.health = 100; // set for integer need to be "intical health for 100"
        this.maxDamage = 5; // set for integer "can give a
        // maximum damage of 5 points."

    }

    // Methods from pdf
    // +getName(): String
    public String getName() {
        return name;
    }

    // +setName (name: String)
    public void setName(String name) {
        this.name = name;
    }

    // + setHeath(helath: int)
    public int setHealth() {
        return health;
    }

    // +getHelath(): int
    public void gethealth(int health) {
        this.health = 100;
    }

    // +setMaxDamage(maxDamage:int)
    public void maxDamage(int maxDamage) {
        this.maxDamage = 5;
    }

    // +getMaxDamage() int
    public int getMaxDamage(int maxDamage) {
        return maxDamage;
    }

    // +dealDamage (other: Player)
    // The Player class’s dealDamage method should apply damage to the Player object
    // based on a random number between 0 and the maxDamage from the other Player
    // object.
    public void dealDamage(Player other) {
        Random ran = new Random();
        int damage = ran.nextInt() + 0;// between 0 and the maxDamage
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
        String winner;

        // in main have One Player instance has name “One Punch Man”, initial health of
        // 100, and can
        // give a maximum damage of 20 points.
        // have the two charcter for alien and player
        Player onePunchMan = new Player(oneName, twoName);
        Player alien = new Player(oneMaxDamage, twoMaxDamage);

        // intial helath for player
        onePunchMan.setHealth();
        alien.setHealth();

        // winner
        System.out.println("the winner is..." + winner);
    }

}
