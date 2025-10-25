import java.io.*;
import java.util.*;

//this was given to finish the version of the project with help from others
public class Example  {
    private static final String WORDS_FILE = "words.txt";
    private static String chosenWord;
    private static Set<String> validWords = new HashSet<>();
    private static Set<String> guessedWords = new HashSet<>();
    private static int score = 0;
    private static char[] scrambledLetters;
    
    public static void main(String[] args) {
        loadWords();
        chooseWord();
        scrambleLetters();
        playGame();
    }
    
    private static void loadWords() {
        try (BufferedReader br = new BufferedReader(new FileReader(WORDS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                validWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading words file: " + e.getMessage());
            System.exit(1);
        }
    }
    
    private static void chooseWord() {
        List<String> candidates = new ArrayList<>();
        for (String word : validWords) {
            if (word.length() == 7 && hasUniqueLetters(word)) {
                candidates.add(word);
            }
        }
        if (candidates.isEmpty()) {
            System.out.println("No suitable words found.");
            System.exit(1);
        }
        chosenWord = candidates.get(new Random().nextInt(candidates.size()));
    }
    
    private static boolean hasUniqueLetters(String word) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueLetters.add(c);
        }
        return uniqueLetters.size() == 7;
    }
    
    private static void scrambleLetters() {
        scrambledLetters = chosenWord.toCharArray();
        List<Character> letterList = new ArrayList<>();
        for (char c : scrambledLetters) {
            letterList.add(c);
        }
        Collections.shuffle(letterList);
        for (int i = 0; i < scrambledLetters.length; i++) {
            scrambledLetters[i] = letterList.get(i);
        }
    }
    
    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Word Game!");
        displayScrambledLetters();
        
        while (true) {
            System.out.print("Enter a word or command: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("bye") || input.equals("exit")) {
                System.out.println("Thank you for playing this game?");
                break;
            } else if (input.equals("mix")) {
                scrambleLetters();
                displayScrambledLetters();
            } else if (input.equals("ls")) {
                displayGuessedWords();
            } else {
                processWord(input);
            }
            System.out.println("Score: " + score);
        }
        scanner.close();
    }
    
    private static void displayScrambledLetters() {
        for (char c : scrambledLetters) {
            System.out.println(c);
        }
    }
    
    private static void displayGuessedWords() {
        for (String word : guessedWords) {
            System.out.println(word);
        }
    }
    
    private static void processWord(String word) {
        if (word.length() < 4 || !validWords.contains(word) || guessedWords.contains(word) || word.contains("x")) {
            System.out.println("Invalid word.");
            return;
        }
        guessedWords.add(word);
        int points = (word.length() == 4) ? 1 : word.length();
        score += points;
    }
}

