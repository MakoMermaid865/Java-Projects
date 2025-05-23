/*
Ari Kinney
Simon Says
*/

import java.util.Scanner;
import java.util.Random;

public class RedoSimon {

/** Method for easy mode
 * @param colors
 * @return a random color red, blue, green, or yellow
 */
public static String easy(Random colors) {
    int random = colors.nextInt( 4);
    if (random == 0) {
        return "red";
    } else if (random == 1) {
        return "blue";
    } else if (random == 2) {
        return "green";
    } else {
        return "yellow";
    }
}

/** Method for hard mode
 * @param numbers
 * @return a random integer between 0-9
 */
public static int hard(Random numbers) {
    return numbers.nextInt(10);
}

/** code from pdf
 * @param scan
 * @return clear screen
 */
public static void pauseClear(){
    try{
        System.out.print("3... ");
        Thread.sleep(1000);
        System.out.print("2... ");
        Thread.sleep(1000);
        System.out.print("1... ");
        Thread.sleep(1000);

    }catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    //This code will work better I got it from PDF of Milligan last semester
    System.out.println("\033[H\033[2J");
    System.out.flush();
}

//Play again method
/** Method for playing again
 * @param scan
 * @return true or false
 */
public static boolean playAgain(Scanner scan){
    String answer;
    while (true){
        System.out.print("Do you want to play again, type yes or no? ");
        answer = scan.nextLine().trim().toLowerCase();
        if (answer.equals("yes")){
            return true;
        }
        else if (answer.equals("no")) {
            return false;
        }
        else{
            System.out.println(" Thats is not what I asked try again please! ");
        }

    }
}
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner (System.in);
        Random random = new Random();
        String userInput;
        String level= ""; // "" act as a place holder
        String game = "";
        String newItem;
        String correct;
    
        do {
            System.out.println (" Chose your level easy or hard");
            level = scan.nextLine().trim().toLowerCase(); //makes it to ignore case sensitivity
        } while (!level.equals("easy") && !level.equals("hard"));
        
        //https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
        StringBuilder sequence = new StringBuilder();
        int pointsTotal = 0;

        while (true){
            //follow in notes in github post
            newItem = level.equals ("easy") ? easy(random) : String.valueOf(hard(random));
            sequence.append(newItem).append (" ");
            game = sequence.toString().trim();

            //Clear screen sequence
            System.out.println ("Simion Says: " + sequence.toString().trim());
            Thread.sleep(3000);
            pauseClear();

        //The user info is compared to the sequence that was aleady given and points are given for the response
        System.out.println("Repeat the sequence");
        userInput = scan.nextLine().replaceAll("\\s+", " ").trim(); //https://stackoverflow.com/questions/65668953/what-is-use-of-replaceall-s
        correct = game.replaceAll("\\s+", " ").trim();
        
        if (!userInput.equalsIgnoreCase(correct)){ //Teehee Ms. Milli code 
            System.out.println("Im sorry that's not right! Your score..." + pointsTotal);
            boolean playAgain = playAgain(scan);
            if (playAgain == true){
                sequence = new StringBuilder();
            }else{
                break;
            }
        }

        pointsTotal++;
    }
    scan.close();  
}
}

//please know that I used ai in gradeing this assignment I prompt it to act as a grader and assign me the grade I would get in the assignment