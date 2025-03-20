import java.io.*;
import java.util.*;
//this code was generated by ai
public class ExtraC {

    private static Set<String> validWords = new HashSet<>();
    private static List<String> words = new ArrayList<>();
    private static int score = 0;
    private static String currentWord;

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        loadWords("words.txt");
        startGame(scnr);
        scnr.close();
    }

    private static void loadWords(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 7 && hasUniqueLetters(line)) {
                words.add(line);
            }
        }
        reader.close();
    }

    private static boolean hasUniqueLetters(String word) {
        return word.chars().distinct().count() == word.length();
    }

    private static void startGame(Scanner scnr) {
        while (true) {
            currentWord = getRandomWord();
            String scrambled = scrambleWord(currentWord);
            System.out.println("Scrambled word: " + scrambled);
            System.out.println("Score: " + score);
            System.out.println("Enter your action (mix, ls, bye, or a word):");

            String input = scnr.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (input.equalsIgnoreCase("mix")) {
                scrambled = scrambleWord(currentWord);
                System.out.println("Scrambled word: " + scrambled);
            } else if (input.equalsIgnoreCase("ls")) {
                System.out.println("Valid words: " + validWords);
            } else {
                checkWord(input);
            }
            System.out.println("Score: " + score);
        }
    }

    private static String getRandomWord() {
        Random rand = new Random();
        return words.remove(rand.nextInt(words.size()));
    }

    private static String scrambleWord(String word) {
        char[] letters = word.toCharArray();
        List<Character> letterList = new ArrayList<>();
        for (char c : letters) {
            letterList.add(c);
        }
        Collections.shuffle(letterList);
        StringBuilder scrambled = new StringBuilder();
        for (char c : letterList) {
            scrambled.append(c);
        }
        return scrambled.toString();
    }

    private static void checkWord(String word) {
        if (currentWord.equalsIgnoreCase(word) && !validWords.contains(word)) {
            validWords.add(word);
            score += 10; // Example scoring
            System.out.println("Valid word! Points earned: 10");
        } else {
            System.out.println("Invalid word.");
        }
    }
}

