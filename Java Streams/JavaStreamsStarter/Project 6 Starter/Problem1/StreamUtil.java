import java.util.Random;
import java.util.stream.IntStream;

public class StreamUtil
{
   /**
    * Measures the time it takes to count the number of odd numbers using
    * an infinite stream, given a limit. 
    * @param generator the Random generator used to generate the numbers.
    * @param limit the number of odd numbers to count
    * @param isParallel if true, use a parallel stream
    */
   public static long timeOdds(Random generator, int limit, boolean isParallel)
   {
      long result = 0;
      //TODO: Your work goes here
     long startTime = System.nanoTime();
     IntStream stream = IntStream.generate(generator::nextInt);
     if (isParallel) {
         stream = stream.parallel();
      }
      stream
         .filter(n -> n % 2 != 0)
         .limit(limit)
         .count();
      long endTime = System.nanoTime();
      result = endTime - startTime;

      return result;
   }
}