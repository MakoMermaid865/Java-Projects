import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

//I watched a video to get a layout of how the code should look
//https://www.youtube.com/watch?v=AYF3pPWRJ6o&t=0s
public class ProjectC {
    private static final String words_File = "words.txt";
    // Resource for help on hashmaps and sets
    // https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
    // https://www.geeksforgeeks.org/set-in-java/
    private static Set<String> validWords = new HashSet<>();
    private static ArrayList<String> guessedWords = new ArrayList<>();
    private static String mix;
    private static int score = 0;

    /**
     * displays the same letters in a new order
     * 
     * @param word will be mixed
     * @return mixedword.toString();
     *         https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
     */
    public static String mix(String word) {
        char[] letter = word.toCharArray();
        StringBuilder mixedWord = new StringBuilder();
        // Ms.M GitHub EX: for (int j = (colors[i].length - 1); j >= 0; j--)
        for (int i = letter.length - 1; i >= 0; i--) {
            mixedWord.append(letter[i]);
        }
        return mixedWord.toString();
    }

    /**
     * a word method checks if that word was valid
     * /**Josh code in lab the bufferReader was made into a method and will be
     * called into the main method
     * 
     * @param reader for the bufferReader
     * @return N/A
     * @throws IoException if the I/O error happens
     */
    public static void aWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(words_File));
        String readLine = reader.readLine();
        while (readLine != null) {
            System.out.println(readLine);
            validWords.add(readLine.trim());
            readLine = reader.readLine();
        }
        reader.close();

    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Time for a spelling Bee!!!");
        System.out.println(
                "If you need to exit type bye, type mix to scramble letters, type ls for all the words you want to see guessed! ");

        String userInput;
        aWord();
        String word = "pluming"; // this is the word that should be used in the pdf provided
        mix = mix(word);

        System.out.println("Scrambled letters: " + mix);
        userInput = scnr.nextLine();

        while (true) {
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Byyeeee!!");
                userInput = scnr.nextLine();
                System.exit(0);
            } else if (userInput.equalsIgnoreCase("mix"))
                ;
            {
                mix = mix(word);
                System.out.println("New scrambled letters:" + mix);
                userInput = scnr.nextLine();
            }
            if (userInput.equalsIgnoreCase("ls")) {
                System.out.println("Guessed Words:" + guessedWords);
                userInput = scnr.nextLine();
            } else // help from tutor in the student success center
            {
                if (word.length() < 4 || guessedWords.contains(word) || !validWords.contains(word)) {
                    System.out.println("Invalid word, Please try again.");
                    userInput = scnr.nextLine();

                }

                else {
                    guessedWords.add(word);
                    int length = word.length();
                    int points;
                    if (length == 4) {
                        points = 1;
                    } else if (length > 5) {
                        points = length * 2 ;
                    } else {
                        points = length;
                    }
                    score += points;
                    System.out.println("Good job...you earned points: " + points);
                }
            }
            System.out.println("Score: " + score);
            userInput = scnr.nextLine();
        }
    }
}
