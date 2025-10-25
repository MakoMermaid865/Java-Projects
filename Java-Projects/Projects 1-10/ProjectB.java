
//Ari Kinney
// 10/05/24
// CS-1180
// Simone Say Project
import java.util.Random;
import java.util.Scanner;
public class ProjectB {
    /**
     * @param : The method is made to clear the screen to get the nexr input for the game to
     * contiue for simone say
     * I got the clear screen method from the pdf in piliot on simon say and
     * @return: This method clears the screen and signials the terminal that a command sequence is abbout to happen.
     */
    
     //Method for clearing the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /**
     * @param : rainbow generates random colors from the conditional statment using the random class to pick a index
     * @return: A string representing a randomly selected color red blue green or "yellow
     */

    // Method for easy mode
    public static String easy(Random rainbow) {
        int random = rainbow.nextInt(4);
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
    
    /**
     * @param : Method for Hard mode by defining the numbers with a random interger and the
     * bound 0-9 b/c you start with index 0, This will allow the method to generate a random single digit number (0-9)
     * using the random class
     * @return: a random interger and the 0-9 b/c you start with index 0 for the bound
     */
    
     // Method for Hard mode
    public static int hard(Random digits) {
        return digits.nextInt(10);
    }

    /**
     * @param : ask the user to play again
     * @return: A string reckonizing if the user's choice to play again or not
     */
    
     // Method for tryagain
    public static String TryAgain() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would you like to play again? Enter yes or no ");
        String redo;
        redo = scnr.nextLine();

        while (!redo.equalsIgnoreCase("Yes") && !redo.equalsIgnoreCase("No")) {
            System.out.println("No thats not what you should put. Please follow directions and enter 'Yes' or 'No'! ");
            redo = scnr.nextLine();
            if (redo.equalsIgnoreCase("No")) {
                scnr.close();
                System.exit(0);}
                else if (redo.equalsIgnoreCase("No")) {

                }
            
            else{
                clearScreen();
            } 
            
        }
        return redo;
    }

    public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String mode;
    String userinput;
    String SimonSays;
    int pointstotal =0;

    do{
        //Start the game by asking the user the level they want to do
        System.out.println("CHOSE YOUR LEVEL: Easy or Hard! ");
        mode = scanner.nextLine();
    }
    while (!mode.equalsIgnoreCase("Easy") && !mode.equalsIgnoreCase("Hard"));{
                System.out.println("Please follow directions and enter 'Easy' or 'Hard'! ");
                mode = scanner.nextLine();
            }
// A sequence of colors or number will be made based on the chosen mode that will repeat for a infinit loopy
                //Mode sequence...the if-else loop was expained in tutoring at the student succes center
                if (mode.equalsIgnoreCase("Easy")){
                SimonSays = easy(random);
                }
                else{//hard mode 
                    SimonSays = String.valueOf(hard(random));
                }
            
//After displaying the sequence the program will wait 3 seconds, clear screen and ask the user to input their response           
// Clear the screen/ Sequence

    System.out.println("Simon Says:" + SimonSays);
    Thread.sleep(3000);
    clearScreen();

//The user input is compared to the generated sequence and points are given for the response
    System.out.println("Repeat the sequence");
    userinput = scanner.nextLine();
        if (!userinput.equalsIgnoreCase(SimonSays)){
            System.out.println("Im sorry that's not right! Your score..." + pointstotal);
            return;
        }
    pointstotal++;
    
//The game will contiue until user choses not to play again
    do { 
        TryAgain();
    }
        while (true);
    
}
}
//Reflection: need to get better at speed typing and coming up with the soution faster


