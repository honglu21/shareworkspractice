package com.iteratrlearning.testing.examples.m4_tdd;

import org.junit.jupiter.api.Test;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapTest {

    public static final int LINE_LENGTH = 5;

    // a method that breaks words on specified space with new line, like a word processor would.
    private String wrap(String line, int lineLength) {
        StringBuilder builder = new StringBuilder();
        int inputLength = line.length();
        builder.append(line, 0, min(inputLength, lineLength));

        int split = lineLength;

        while (inputLength > split) {

            builder.append("\n").append(line, split, min(inputLength, split + lineLength));
            split = split + lineLength;
        }

        return builder.toString();

    }


    @Test
    public void lineShouldWrapIfOverLineLength() {
        String result = wrap("The Sleepy", LINE_LENGTH);
        System.out.println("result " + result);
        assertEquals("The S\nleepy", result);
    }


    @Test
    public void shortLinesShouldNotWrap() {
        String result = WordWrap.wrap("The", LINE_LENGTH);
        System.out.println("result " + result);
        assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice() {
        String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
        System.out.println("result " + result);
        assertEquals("The S\nleepy\n Brow", result);
    }

    @Test
    public void evenLongerLinesShouldWrapThrice() {
        String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        System.out.println("result " + result);
        assertEquals("The S\nleepy\n Brow\nn Fox", result);
    }

    @Test
    public void longLinesDontHaveToBeAMultipleOfLineLength() {
        String result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
        System.out.println("result " + result);
        assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);
    }

}
