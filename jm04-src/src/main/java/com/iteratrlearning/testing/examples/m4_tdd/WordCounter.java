package com.iteratrlearning.testing.examples.m4_tdd;

public class WordCounter {
    private String word;
    private int counter;

    public WordCounter(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    public String getWord() {
        return word;
    }

    public int getCounter() {
        return counter;
    }

    public static int count(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        return 0;
    }





}
