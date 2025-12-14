import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Complete the methods below. You may add helper methods
 * as you require.
 */
public class Words
{      
   /**
    * The noLetterRepeated method reads all of the words 
    * in filename and returns a list of all words with 
    * length of at least ten, in which no letter is repeated.
    * You may assume that filename has one word per line.
    */
   public static List<String> noLetterRepeated(String filename)
   {
      //TODO: Your work goes here
      try (Stream<String> line = Files.lines(Paths.get(filename))) {
         return line
         .map(String::trim)
         .filter(word -> !word.isEmpty())
         .filter(word -> !word.endsWith("s"))
         .filter(word -> word.length() >= 10)
         .filter(Words::allUniqueLetters)
         .collect(Collectors.toList());
      }
      catch (IOException e) {
         e.printStackTrace();
         return List.of(); 
      }
   }

   /**
    * The longestWord method takes a Stream<String> and
    * returns the longest word in the stream.
    */
   public static String longestWord(Stream<String> stream)
   {
      String result;
      //TODO: Your work goes here
      result = stream.reduce("", (a, b) -> a.length() >= b.length() ? a : b);
      return result;
   }
   
   /**
    * Given a Stream<String> and a length, 
    * returns the number of words of that length in the stream.
    */
   public static long wordCount(Stream<String> stream, int len)
   {
      long result;
      //TODO: Your work goes here
      result = stream.filter(word -> word.length() == len).count();
      return result;
   }

   /**
    * Helper method to check if all letters in a word are unique
    * @param word
    * @return true if all letters are unique, false otherwise
    */
   private static boolean allUniqueLetters(String word) {
      boolean[] seen = new boolean[26];
      for (int i = 0; i < word.length(); i++) {
         char c = Character.toLowerCase(word.charAt(i));
         if (c < 'a' || c > 'z') {
              continue; // Ignore non-letter characters
         }
         int index = c - 'a';
         if (seen[index]) {
            return false;
         }
         seen[index] = true; 
      }
      return true; 
   }
   }

