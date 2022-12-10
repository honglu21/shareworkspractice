package com.iteratrlearning.testing.answers.m4_tdd;

import org.eclipse.jetty.http.HttpFields;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounter
{
    private static Set<String> delimiters = new HashSet<>();

    public WordCounter()
    {
        addDelimiter(' ');
        addDelimiter(',');
    }

    public static int count(final String str)
    {
        final String regex = String.join("|", delimiters);

        return (int) Arrays
                .stream(str.split(regex))
                .filter(word -> !word.isEmpty())
                .distinct()
                .count();
    }

    public void addDelimiter(final char delimiter)
    {
        delimiters.add(String.valueOf(delimiter));
    }
}
