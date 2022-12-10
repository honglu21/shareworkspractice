package com.iteratrlearning.testing.answers.m4_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest
{
    private WordCounter wordCounter = new WordCounter();

    @BeforeEach
    public void setUp()
    {
        wordCounter.addDelimiter(':');
        wordCounter.addDelimiter(';');
    }

    @Test
    public void shouldHaveZeroWordsInEmptyString()
    {
        assertCount("", 0);
    }

    @Test
    public void shouldHaveOneWordInWhenNoDelimiters()
    {
        assertCount("Richard", 1);
    }

    @Test
    public void shouldHaveTwoWordsWithOneDelimiter()
    {
        assertCount("Richard,Raoul", 2);
    }

    @Test
    public void shouldNotCountEmptyWordsAsStrings()
    {
        assertCount("Richard,,Raoul", 2);
    }

    @Test
    public void shouldNotCountDuplicateWords()
    {
        assertCount("Richard,Richard,,Raoul", 2);
    }

    @Test
    public void shouldAllowWhiteSpaceAsSeparator()
    {
        assertCount("Richard is great,Richard,,Raoul", 4);
    }

    @Test
    public void shouldAllowCustomCharacterAsSeparator()
    {
        assertCount("Richard is:great,Richard,,Raoul", 4);
    }

    @Test
    public void shouldAllowMultipleCustomDelimitersAsSeparator()
    {
        assertCount("Richard is:great,Ric;,Raoul", 5);
    }

    @Test
    public void shouldSupportNoCustomDelimiters()
    {
        final WordCounter wordCounter = new WordCounter();

        final int count = wordCounter.count("Richard is:great,Ric;,Raoul");

        assertEquals(4, count);
    }

    private void assertCount(final String str, final int expected)
    {
        final int count = wordCounter.count(str);

        assertEquals(expected, count);
    }

}
