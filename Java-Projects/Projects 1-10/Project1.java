//Change into a story line of muder mystery on 1/17/22
import java.util.Scanner;
public class Project1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        double budget;
        boolean moneyQuestion;
        String shoppingPlace;
        String nova;
        String hairOrGas;
        double total;
        boolean countiueDate;
        boolean unleaded;
        String jewlery;
        String gift;
        String smellGoods;
        String nextThree;
        char date;
        //Get user information
        System.out.println("Heyyy! Time for date night...What is your name ? ");
        name = scan.nextLine();

        System.out.println("We need to budget!!! How much money are you planing to spend today? Please include change like 145.67 and range from 0-200 dollars! ");
        budget = scan.nextDouble();
        if (budget >= 200) {
            System.out.println("Please follow directions the range needs to be 200 or less ");
        } else {
            System.out.println("That is great!");
        }

        scan.next();

        System.out.println("As you are driving to get ready for the date you wonder; Does spending more money guarantees you to hava a better date?   ");
        moneyQuestion = scan.nextBoolean();

        //Choice 1...Where are we going shopping? Remember your budget
        System.out.println("Hey " + name + "? Where are we going shopping: A.Gucci, B. FashionNova, or C. GoodWheel? (Please type A B or C ");
        shoppingPlace = scan.nextLine();
        //Choice 1.A
        if (shoppingPlace.equalsIgnoreCase("A")) {
            System.out.println("Oh Nooooo...You spent way to much money at Gucci now you are in debt with 5,000 dollars!"); //Ending 2
            return;
        }
        //Choice 1.B
        else if (shoppingPlace.equalsIgnoreCase("B")) {
            System.out.println("Wow " + name + "; That outfit looks amzaing on you! But we have to hurry time is running out!");
            //Choice 4
            System.out.println("Before you go looks like your gas is low, what are you doing next? Pick A. Ignore it and go to hair appoint B. Put Gas in the car? ");
            hairOrGas = scan.nextLine();
            //Choice 4.A Caluation and decsion with true and false
            if (hairOrGas.equalsIgnoreCase("A")) {
                System.out.println("Great you made it to the hair appoinment just fine, But you spent 120 on your hair. Lets where your budget is at now?(It was mostly inflation and taxes that cuased the high price lol)");
                total = budget - 120;
                System.out.println("Look like you have" + budget + "left");
                // Choice 4 Decision 2 boolean
                System.out.println("Do you still want to go out? Pick A. True(yes) B.False(no) Please type A or B! ");
                countiueDate = scan.hasNextBoolean();
                if (countiueDate = equalsIgnoreCase("True"))//Yes go on date
                {
                    System.out.println("No you Did not make it! Your car brook down in the middle of the highway and got hit!");//ending 6
                } else if (countiueDate = equalsIgnoreCase("False"))//No reshedule date
                    System.out.println("Even though you you reshedule; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!"); //Ending 5
            } else {
                System.out.println("Looks like you type in something wrong, Follow directions and retry!");
            }
            //Choice 4.B another decion with true and fals ending
        } else if (hairOrGas.equalsIgnoreCase("B")) {
            System.out.println("Great you made it to the gas station but is your Toyota able to run on unleaded? A. True (yes) B.False(No) ");
            unleaded = scan.hasNextBoolean();
            if (unleaded.equalsIgnoreCase("True")) {
                System.out.println("Even though you you reshedule; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!");//Ending 5
            } else if (unleaded.equalsIgnoreCase("False")) {
                System.out.println("Oh dear, looks like you put desiel in the car becuase you thought it wasn't able to take unleaded. But the car exploeded with you in it and you passed away! Next time put the right gas in the car!"); //Ending 4
                return;
            } else {
                System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            }
        } else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            //Ask the question again does the car run on unleaded
        }
    }
        //Choice 1.C
        else if (shoppingPlace.equalsIgnoreCase("C")) {
            System.out.println("Great you got a great outfit for a awesome deal!");
                 //Choice 2
            System.out.println("What are we doing next? Pick A. Get new Jewlery B. Buy a gift for yout significat other C.Get Clone/Perfume");
            if (nextThree.equalsIgnoreCase("C")) {
                //Decesion 1 with
                System.out.println("Oh no your skin green and you try to treat. You know it ok to ignore becuase it will fade away, was that the best approch? Pick A. True B. False (type A or B) ");
            }
            else if (nextThree.equalsIgnoreCase("B")) {
                System.out.println("You got a great gift");
                System.out.println("Now are you finally ready? A. Break up  B.Go on Date (Type A or B)");
                //Choice 3
                if (date.equalsIgnorCase("A")) {
                    System.out.println("You should never ignore it! It was worse than you thought and you had to call 911 but they got to you to late and you passed away!");
                }
                    else if (date.equalsIgnoreCase("B")) {
                        System.out.println("The date wad awsome and you had a great time on a skylight hotell"); //Ending 3
                }
                    else {
                    System.out.println("Looks like you types in something wrong, Follow directions and retry!");
                }

            }
            else if (nextThree.equalsIgnoreCase("A")) {
                System.out.println("Looks like you had a allergic reaction and cancelled. But the next day he/she surpised you with a nice couple massage and body care treatment to help with skin irration! You had a good date after all!");
                //Ending 1
                if ("True") {
                    System.out.println("Even though you you reshedule; She/Him Surpised you at your place and ended V-day with great movie by the fireplace roasting smores! You had a great date after all!"); //Ending 5
                    //Ending 5
                }
                else if ("False") {
                    System.out.println("You should never ignore it! It was worse than you thought and you had to call 911 but they got to you to late and you passed away!");
                    //Ending 4
                }
                else {
                    System.out.println("Looks like you types in something wrong, Follow directions and retry!");
                }
            }
            else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
            //Re prompt user

        }

    } else {
            System.out.println("Looks like you types in something wrong, Follow directions and retry!");
        }
    }
}
//I did copy and paste from Grammerally to fix writing
