import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ProjectC {
    private static final String words_File = "words.txt";
    // https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
    // https://www.geeksforgeeks.org/set-in-java/
    private static Set<String> validWords = new HashSet<>();
    private static ArrayList<String> guessedWords = new ArrayList<>();
    private static String mix;
    private static int score = 0;

    /**
     * mix the letters
     * @param word will be mixed
     * @return mixedWord.toString();
     */
    public static String mixLetters(String word) {
        List<Character> letterList = new ArrayList <>();
        for (char c : word.toCharArray()) {
            letterList.add(c);
        }
        Collections.shuffle(letterList);

        //copy from last project lol
        StringBuilder mixedword = new StringBuilder();
        for (char c : letterList){
            mixedword.append(c);
        }
        return mixedword.toString();

    }

    /** " Choose a word from `words.txt` that has exactly 7 unique letters. 
     * @param reader for the bufferReader
     * @return
     * @throws IoException if the I/O error happens
     */
    public static void loadWords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(words_File));
        String readLine;
        while ((readLine = reader.readLine()) != null) {
            readLine = readLine.trim();
            if (hasSevenLetters(readLine)) {
                validWords.add(readLine);
            }
        }
        reader.close();

    }

    private static boolean hasSevenLetters(String word) {
        return word.chars().distinct().count()== 7;
    }

    /**   //Select a random word from words.txt
     * @param word that is selected from file will be used in game
     * @return random word from file
     */
    public static String randomWord() {
        ArrayList<String> words = new ArrayList<>(validWords);
        return words.get((int)(Math.random() * words.size()));
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("** Word Scramble Game **");
        System.out.println("To exit type bye | To scramble letters type mix | To see guessed words type ls");

        String userInput;
        loadWords();

        mix = mixLetters(word);

        System.out.println("Scrambled letters: " + mix);
        userInput = scnr.nextLine();

        while (true) {
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Thank you for playing. ");
                System.exit(0);

            } else if (userInput.equalsIgnoreCase("mix")){
                mix = mixLetters(word);
                System.out.println("New scrambled letters: " + mix);
                userInput = scnr.nextLine();
            }
            if (userInput.equalsIgnoreCase("ls")) {
                System.out.println("Guessed Words:" + guessedWords);
                userInput = scnr.nextLine();
            } else {
                if (userInput.length() < 4 || guessedWords.contains(userInput) || !validWords.contains(userInput)) {
                    System.out.println("Invalid word, Please try again.");
                } else {
                    guessedWords.add(userInput);
                    int length = userInput.length();

                    int points = (length == 4) ? 1 ;
    
                    score += points;
                    System.out.println("Good job...you earned points: " + points);
                }
            }
            System.out.println("Score: " + score);
            userInput = scnr.nextLine();
        }
    }
}
