package com.iteratrlearning.testing.problems.m4_tdd;

import com.iteratrlearning.testing.problems.m4_tdd.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// You're going to TDD a problem called "Word Counter"
// TODO: 2. Count the number of words in a comma separated String of words, empty Strings aren't words.
// TODO: 3. Only count the UNIQUE number of words
// TODO: 4. Allow commas or whitespace as separator characters
// TODO: 5. Allow custom delimiters to be added at runtime.
public class WordCounterTest
{
    private String word;
    private WordCounter wordCounter;

    //@BeforeAll
    public void setUp() {
        word = "world, wonderful world!";
    }

    public void testWordCounter() {


    }

    @Test
    public void testEmptyStringWordCount() {
        assertEquals(0, WordCounter.count(""));
    }

    @Test
    public void testCommaSeperatedEmptyStringWordCount() {
        assertEquals(1, WordCounter.count(" , "));
    }

    @Test
    public void testSpaceSeperatedStringWordCount() {

        assertEquals(2, WordCounter.count("hello, world"));
    }


}
