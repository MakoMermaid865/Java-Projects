//This is a triva project working with datatypes and loops
import java.util.Scanner;

public class Triva {
    public static void main(final String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
    
// The datatype that i will be using to add the correct answers for the quiz percentage
int correct= 0;

// Question 1: whole number

    System.out.print ("What is 8 + 8? "); 
    final int  answerA=scanner.nextInt();
    if (answerA==16) {
    correct++;
    System.out.println("Correct!");
    }
    else {
        System.out.println("Incorrect");
    }
/* Im asking the user a math question and then storing the answer as a integer which is the datatype im using for this part
 * then scan and check if the answer is correct and add to the "correct" for the counter
 */
scanner.nextLine();
// Clear the screen- ignors what was asked and done before to focus on the next part of code

//Question 2: String
System.out.print("Who is the richest man in the world in 2024? ");
String answerB = scanner.nextLine();
if (answerB.equalsIgnoreCase("Elon Musk")){
correct++;
System.out.println("Yes, That's right!");
}
else {
System.out.println("No, That's not right!");
}
/* Im asking the user a question and storing it as a string which is not a datatype 
and the equalsIgnoreCase is to comapre the answer and ignore if the answer given is upcase or lowercase and just accept it as is
 */
scanner.nextLine();
// Clear the screen

//Question 3: Boolean ugghhhh!!
System.out.print("Camels have three sets of eyelash? ");
boolean answerC = scanner.nextBoolean();
if (answerC){
    correct++;
    System.out.println("Yes, thats right! Great eye!");
}
else {
    System.out.println(" No that's not right, a Camel has three sets of eyelash!");
}
/* Im asking for a true/false answer and have the datatype being stored as a boolean
and check if the anser is true
 */
scanner.nextLine();
// Clear the screen

//Question 4: Decimal Number
System.out.print("What is the value of the square root of 3 up to the 2nd decimal point? ");
double answerD = scanner.nextDouble();
if (Math.abs(answerD - 1.73)< 0.01){
correct++;
System.out.println("Yaaaaasss!!");
}
else {
System.out.println("Incorrect");
}
/* Im asking for a decimal number and storing it as a double 
and using Math.abs to check the answer is in a small range */
scanner.nextLine();
// Clear the screen

//Question 5: Charchter 
System.out.print("What is the first letter the word (Frog) starts with? ");
char answerE = scanner.nextLine().charAt(0);
if (Character.toLowerCase(answerE) == 'f') {
correct++;
System.out.println("Amazing!");
}
else {
System.out.println("Noooooo!!");
}
/* Im asking for a single charchter and using the datatype char to stor it, its at 0 for index becuase thats how it reads the charchter by starting at 0
 * I used Charchter.toLowercase to tell the diffence between upcase and lowercase letter and accpeting the answer as is
 */
scanner.nextLine();
// Clear the screen

//Add all the correct quiz answers and show the final results
System.out.print("You got " +correct+ " out of five questions correct");
scanner.nextLine();
// find the final percange (/) it b 5 then time by 100
double percentage = (correct / 5.0)* 100;
System.out.println("Your score is: " + percentage + "%!");
scanner.close();
}
}
