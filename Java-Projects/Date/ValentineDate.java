//Ari Kinney
//ValentineDate
//This was made during the week of Valentine so please be nice

import java.util.Scanner;
public class ValentineDate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        double budget;
        boolean moneyQuestion;
        String shoppingPlace;
        String nova;
        String hairOrGas = "";
        double total;
        boolean countiueDate;
        boolean unleaded;
        String jewlery;
        String gift;
        String smellGoods;
        String nextThree= "";
        String date;
        boolean jewelry;

        //Get user information
        System.out.println("Heyyy! Time for date night...What is your name? ");
        name = scan.nextLine();
        System.out.println("Hello " + name + "!");

        while (true){
        System.out.println("We need to budget!!! How much money are you planing to spend today? Please include change like 45.67 and range from 0-100 dollars! ");
        budget = scan.nextDouble();
        if (budget <= 100.00 && budget >= 0.00) {
            System.out.println("That is great!");
            break;
        } else {
            System.out.println("Please follow directions the range needs to be 100 or less ");
        }
        }

        scan.nextLine();//clear the buffer

        System.out.println("As you are driving to get ready for the date you wonder; Does spending more money guarantees you to hava a better date? (Type true or false)   ");
        moneyQuestion = scan.nextBoolean();
        if (moneyQuestion == false) {
            System.out.println("You are right! It is not about the money but the thought and effort that counts!");
        } else { //true satements
            System.out.println("You are wrong! It is not about the money but the thought and effort that counts!");
        }
    
        scan.nextLine();//clear the buffer
        while (true){
        //Choice 1...Where are we going shopping? Remember your budget
        System.out.println("Hey " + name + "? Where are we going shopping: A.Gucci, B. FashionNova, or C. GoodWheel? (Please type A B or C)");
        shoppingPlace = scan.nextLine();

        //Choice 1.A
        if (shoppingPlace.equalsIgnoreCase("A")) {
            System.out.println("Oh Nooooo...You spent way to much money at Gucci now you are in debt with 5,000 dollars and the FEDs came after you!"); //Ending 2
            scan.nextLine();
            System.out.println("You didn't make it!");//Ending 2
            System.exit(0);
        }
        //Choice 1.B
        else if (shoppingPlace.equalsIgnoreCase("B")) {
            System.out.println("Wow " + name + "; That outfit from FashionNova looks amzaing on you! But we have to hurry time is running out!");
            scan.nextLine();//Clear the buffer

            //Choice 4
            System.out.println("Before you go looks like your gas is low, what are you doing next? Pick A. Ignore it and go to hair appointment B. Put Gas in the car? ");
            hairOrGas = scan.nextLine();

            //Choice 4.A Caluation and decsion with true and false
            if (hairOrGas.equalsIgnoreCase("A")) {
                System.out.println("Great you made it to the hair appoinment just fine!");
                scan.nextLine();//Clear the buffer
                System.out.println("But you spent 120 on your hair. Lets see where your budget is at now?(It was mostly inflation and taxes that caused the high price lol)");
                total = budget - 120;
                scan.nextLine();
                System.out.println("Look like you have " + total + " left");

                // Choice 4 Decision 2 boolean
                System.out.println("Since you are low on money, Using a credit card without a plan is a great way to pay stuff back? Please type true or false! ");
                countiueDate = scan.nextBoolean();
                scan.nextLine();
                if (countiueDate == true)//Boolean True with ending 6
                {
                    System.out.println("No thats not right; You need to plan to use the credit card and pay it back on time!But what happens next?");
                    scan.nextLine();
                    System.out.println(" Your car broke down in the middle of the highway and got hit!");//ending 6
                    scan.nextLine();
                    System.out.println("You didn't make it!");
                    System.exit(0);

                } else {//Boolean False with ending 5
                    System.out.println("That is right! You need to plan to use the credit card and pay it back on time! But what happens next?");
                    scan.nextLine();
                     System.out.println("Looks like you had to reshedule due to finances; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!"); //Ending 5
                    scan.nextLine();
                    System.out.println("You survived the date!");
                    System.exit(0); 
            }
            
            //Choice 4.B another decion with true and fals ending
        } 
        else if (hairOrGas.equalsIgnoreCase("B")) {
            //Decesion 1
            System.out.println("Great you made it to the gas station but is your Toyota able to run on unleaded? True or False?");
            unleaded = scan.nextBoolean();
            scan.nextLine();

            if (unleaded == true) { //Ending 5
                System.out.println("That is right! You are able to put unleaded in your car! But what happens next?");
                scan.nextLine();
                System.out.println("There was heavy traffic on the way (three truck collisons), and the roads were shut down. You had to reshedule due to traffic!");
                scan.nextLine();
                System.out.println("Looks like you had to reshedule; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!");//Ending 5
                scan.nextLine();
                System.out.println("You survived the date!");
                System.exit(0); 

            } else { //Ending 4
                System.out.println("No that is not right! You are able to put unleaded in your car! But what happens next?");
                scan.nextLine();
                System.out.println("Oh dear, looks like you put desiel in the car becuase you thought it wasn't able to take unleaded.");
                scan.nextLine();
                System.out.print("The car exploeded with you in it and you passed away!"); //Ending 4
                scan.nextLine();
                System.out.println("You didn't make it!");
                System.exit(0);

            }
        
        } else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            continue;
        }
    }
        
        //Choice 1.C
        else if (shoppingPlace.equalsIgnoreCase("C")) {
            System.out.println("Great you got a great outfit at GoodWheel for a awesome deal!");
            scan.nextLine();//Clear the buffer

             //Choice 2
            System.out.println("What are we doing next? Pick A. Get new Jewlery B. Buy a gift for yout significant other C.Get Clone/Perfume (Type A B or C) ");
            nextThree = scan.nextLine();
            if (nextThree.equalsIgnoreCase("C")) { //Choice 2.C
                System.out.println("Oh no looks like when you sprayed it, it got in your eye and you eneded up blind! You should have been more careful!");//Ending 1
                scan.nextLine();
                System.out.println("You didn't make it!");
                System.exit(0);
            }
            else if (nextThree.equalsIgnoreCase("B")) { //Choice 2.B
                System.out.println("You got a great gift");
                scan.nextLine();
                                //Choice 3
                System.out.println("Now are you finally ready? A. No: Break up  B. Yes: Go on Date (Type A or B)");
                date = scan.nextLine();
                    if (date.equalsIgnoreCase("A")) { //Choice 3.A
                    System.out.println("You ended things with your significant other in a rude way! The friends came after you for breaking their heart!");
                    scan.nextLine();  
                    System.out.println("They messed with the breaks in the car and you crashed into 2 gasonline trucks!");
                    scan.nextLine();
                    System.out.print("The car exploeded with you in it and you passed away!"); //Ending 4
                    scan.nextLine();
                    System.out.println("You didn't make it!");
                    System.exit(0);

                    }   
                    else if (date.equalsIgnoreCase("B")) { //Choice 3.B
                        System.out.println("Slayyyyyy!!! Lets see what awaits you!");
                        scan.nextLine();
                        System.out.println("You had a great date and was able to relax. You spent the week in Hawii and went on many adventures together!"); //Ending 3
                        scan.nextLine();
                        System.out.println("You survived the date!");
                        System.exit(0);
                    }

                    else {
                    System.out.println("Looks like you types in something wrong, Follow directions and retry!");
                    continue;
                }

            }
            else if (nextThree.equalsIgnoreCase("A")) { //Choice 2.A
                System.out.println("Great you got great jewlery! But now you are running low on gas, Lets go to the gas station!");
                //Descion 1 ending with true and false
                scan.nextLine();
                System.out.println("Great you made it to the gas station but is your Toyota able to run on unleaded? True or False?");
                jewelry = scan.nextBoolean();
                scan.nextLine();

            if (jewelry == true) { //Ending 5
                System.out.println("That is right! You are able to put unleaded in your car! But what happens next?");
                scan.nextLine();
                System.out.println("There was heavy traffic on the way (three truck collisons), and the roads were shut down. You had to reshedule due to traffic!");
                scan.nextLine();
                System.out.println("Looks like you had to reshedule; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!");//Ending 5
                scan.nextLine();
                System.out.println("You survived the date!");
                System.exit(0); 

            } else { //Ending 4
                System.out.println("No that is not right! You are able to put unleaded in your car! But what happens next?");
                scan.nextLine();
                System.out.println("Oh dear, looks like you put desiel in the car becuase you thought it wasn't able to take unleaded.");
                scan.nextLine();
                System.out.print("The car exploeded with you in it and you passed away!"); //Ending 4
                scan.nextLine();
                System.out.println("You didn't make it!");
                System.exit(0);

            }

        }
        else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            continue;
        }

    } 
    else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            continue;
        }
    }

}
}
//Layout of project and notes are in book...i didn't need a webisite for this so no need to cite sources
