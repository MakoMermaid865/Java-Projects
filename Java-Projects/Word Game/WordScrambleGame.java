import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class WordScrambleGame {
    private static final String WORDS_FILE = "words.txt";
    // https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
    // https://www.geeksforgeeks.org/set-in-java/
    private static Set<String> validWords = new HashSet<>();
    private static ArrayList<String> guessedWords = new ArrayList<>();
    private static String mix;
    private static int score = 0;

    /**
     * mix the letters of the word
     * @param word will be mixed
     * @return scrambled letters of the word
     */
    public static String mixLetters(String word) {
        List<Character> letterList = new ArrayList <>();
        for (char c : word.toCharArray()) {
            letterList.add(c);
        }
        Collections.shuffle(letterList);

        StringBuilder mixedword = new StringBuilder();
        for (char c : letterList){
            mixedword.append(c);
        }
        return mixedword.toString();

    }

    /** " Choose a word from `words.txt` that has exactly 7 unique letters. 
     * @throws IoException if the I/O error happens
     */
    public static void loadWords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(WORDS_FILE));
        String readLine;
        while ((readLine = reader.readLine()) != null) {
            readLine = readLine.trim();
            if (hasSevenExactLetters(readLine)) {
                validWords.add(readLine);
            }
        }
        reader.close();

    }

    /** Check if the word has exactly 7 unique letters
     * @param word that will be checked
     * @return true if the word has 7 unique letters, false otherwise
     */
    private static boolean hasSevenExactLetters(String word) {
        return word.chars().distinct().count( ) == 7;
    }

    /** Select a random word from words.txt
     * @return random word from file
     */ //https://www.youtube.com/watch?v=1Rq_LrpcgIM&t=1s

    
    public static String randomWord() {
        ArrayList<String> words = new ArrayList<>(validWords);
        return words.get((int)(Math.random() * words.size()));
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String userInput;

        System.out.println("                        *** Word Scramble Game ***                       ");  
        System.out.println(" | To exit type bye | To scramble letters type mix | To see guessed words type ls | ");

        userInput = scnr.nextLine();

        loadWords();
        String word = randomWord();
        mix = mixLetters(word);

        System.out.println("Scrambled letters: " + mix);

        while (true) {
        System.out.println("Enter a word or command: ");
        userInput = scnr.nextLine().trim();  

        // Commands listed only should be ls bye and mix 
        if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Thank you for playing...Bye! ");
                scnr.close();
                System.exit(0);

            } else if (userInput.equalsIgnoreCase("mix")){
                mix = mixLetters(word);
                System.out.println("New scrambled letters: " + mix);
                continue; //continue to the next iteration of the loop
            }
            if (userInput.equalsIgnoreCase("ls")) {
                System.out.println("Guessed Words: " + guessedWords);
                continue; //continue to the next iteration of the loop

            //Points system    
            } else {
               // "words less than 4 letters OR words not in `words.txt` OR words that have already been guessed get 0 points"
                if (userInput.length() < 4 || guessedWords.contains(userInput) || !validWords.contains(userInput)) {
                    System.out.println("Invalid word. No points earned.");
                    continue; //player will not get points for invalid words and will be prompted to enter a new word
                } else {
                    guessedWords.add(userInput);
                    int length = userInput.length();

//four letter words are worth 1 point each  
//o `test` = 1 point 
//• words longer than four letters are worth 1 point for each character  
//o `testing` = 7 points
                    int points = (length == 4) ? 1 : length;

                    score += points;
                    System.out.println("Good job...you earned points: " + points);
                }
            }
            System.out.println("Score: " + score);
            userInput = scnr.nextLine();
        }
    }
}
//Ai was used to grade my program and act as a grader. This was to make sure I was on the right track and followed the rubric