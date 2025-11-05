//Ari Kinney
//catacomb project

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.IOException;


public class Catacomb {
    //https://www.youtube.com/watch?v=6wVmqY-CrGM
    // this video helped alot
private String name;
private int health;
private int maxDamage;
private int row;
private int col;

// Player user = new Player( "Bob", 20, 100);
// Player (name: String, maxDamage: int) set for constructor
public String Player(String name, int maxDamge)
{
    this.name = name; // Bob
    this.health = 100; // set for integer need to be "intical health for 100"
    this.maxDamage = 5; // set for integer "can give a
    // maximum damage of 5 points."
        return name;

}

// Methods from pdf
// +getName(): String
public String getName() 
{
    return name;
}

// +setName (name: String)
public void setName(String name) 
{
    this.name = name;
}

// + setHeath(helath: int)
public int setHealth() 
{
    return health;
}

// +getHelath(): int
public void gethealth(int health)
{
    this.health = 100;
}

// +setMaxDamage(maxDamage:int)
public void maxDamage(int maxDamage)
{
    this.maxDamage = 5;
}

// +getMaxDamage() int
public int getMaxDamage(int maxDamage) 
{
    return maxDamage;
}

// +dealDamage (other: Player)
// The Player class’s dealDamage method should apply damage to the Player object
// based on a random number between 0 and the maxDamage from the other Player
// object.
public void dealDamage(Player other) 
{
    Random ran = new Random();
    int damage = ran.nextInt() + 0;// between 0 and the maxDamage
}

// toSting(): String
// The Player class’s toString method should Override the default toString
// method to create a String that contains the Player object’s name and current
// Health Points (HP)
@Override
public String toString()
{
    return name + " HP " + health;
}

public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    
    String winner;
    String heroName;
    int width;
    String hero;
    int monsterX; //set cordint for monster later in code
    int monsterY;

    System.out.println("What is the Hero's name: ");
    heroName = scnr.nextLine();

    System.out.println("How wide of a catacomb do you want to face (5-10)? "); // pdf output
    width = scnr.nextInt(); 

    //Now that the user can set the grid the logic of or command will set the grid
    if (width < 5 || width > 10)
    {
        System.out.println("No that is not the right size, please try that again! Use numbers between 5 and 10!  ");
        return;
    }


    // set catacomb
    // give a maximum damage of 20 points.
    // have the two charcter for hero and random monst
    Random rand = new Random();
    char[][] catacomb = new char[width][width];
    Player sHero = new Player(heroName, 20);
    //https://stackoverflow.com/questions/15249138/pick-random-char

    //this was looked over by my last lab so there was c+p here but things were changed
    //set the catcomb with empty rooms
    //https://www.geeksforgeeks.org/examples-of-big-o-analysis/
    for (int i= 0; i< width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            catacomb [i][j] = '-';
        }
    }
    

    //Place the hero the northwest conrner when the game start
    catacomb [0][0] = 'H';// this work b/c a char was only asked in the begin to be placed

    // catacomb spacing/rows
    for (int i= 0; i< width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            catacomb [i][j] = ' ';
        }
        System.out.println();
    }

//"There is one monster in the catacomb for every six rooms"- from pdf
// meaning the width of the room set by the user is divied my the rows the trick is the random selection
    int monsterTotal = width / 6; // this should result to 1
    //https://www.baeldung.com/java-array-count-inversions
    for (int i= 0; i<monsterTotal; i++) 
    {
        do
        {
            monsterX = rand.nextInt(width);
            monsterY = rand.nextInt(width);
        }
        while (catacomb [monsterX][monsterY] != '-');
        {
            catacomb [monsterX][monsterY] = 'M';
        }
    }
}       
}