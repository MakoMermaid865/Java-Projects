# Java Streams

This project demonstrates the use of Java Streams to solve three problems involving random number generation, word processing, and data analysis on a movie dataset.

All programs are run from the terminal to ensure correct file handling and stream execution.

## Problem 1: Parallel vs Sequential Streams

Files:
- `StreamUtil.java`
- `ParallelOddsDemo.java`

Description:
This problem measures the time it takes to count a given number of odd random integers using Java streams. The method compares sequential streams versus parallel streams and reports which one is faster for increasing values of `n`.

The stream:
- Generates random integers
- Filters for odd values
- Stops after `n` odd numbers
- Uses `System.nanoTime()` to measure execution time
- Optionally runs as a parallel stream

How to run (from the `Problem1` directory):
javac StreamUtil.java ParallelOddsDemo.java
java ParallelOddsDemo


## Problem 2: Word Properties Using Streams

Files:
- `Words.java`
- `WordsTester.java`
- `words.txt`

Description:
- Finds words with no repeated letters
- Excludes possessive words ending in 's
- Only includes words of length 10 or greater F
- Finds the longest word Counts words of specific lengths
- All results are compared against expected outputs provided by the tester

### How to run (from the Problem2 directory):
javac Words.java WordsTester.java
java WordsTester

## Problem 3: Most Common Initial Words in Movie Titles

Files:
- `Movie.java`
- `Movies.java`
- `MoviesTester.java`
- `movies.txt`

Description:
This problem analyzes a dataset of movie titles to determine the most common starting words. The solution:
- Extracts the first word from each title
- Counts how often each starting word appears
- Sorts results by frequency (descending), then alphabetically
- Returns the top 100 most common initial words
- The output is validated using expected results provided in MoviesTester.

### How to run (from the Problem3 directory):
javac Movie.java Movies.java MoviesTester.java
java MoviesTester
