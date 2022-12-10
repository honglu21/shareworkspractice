package com.iteratrlearning.testing.problems.m4_tdd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private static String delimeter;
    private String word;
    private int counter;

    private List<String> delimeters;

    public WordCounter() {
        addDelimeter(' ');
        addDelimeter(',');
    }

    public String getWord() {
        return word;
    }

    public int getCounter() {
        return counter;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    public List<String> getDelimeters() {
        return delimeters;
    }

    public void setDelimeters(List<String> delimeters) {
        this.delimeters = delimeters;
    }

    public static long count(String input) {

        final String regex = String.join("|", delimeter);
        if (input==null || input.isEmpty()) {
            return 0;
        }

//        List<String> list = Stream.of(input).map(w -> w.split(",")).flatMap(Arrays::stream)
//                .collect(Collectors.toList());
//
//        Map<String, Integer > wordCounter = list.stream()
//                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
//
//        System.out.println(wordCounter);

        return Arrays.stream(input.split(regex))
                .filter(s->!s.isEmpty()).distinct().count();

    }

    public void addDelimeter(char delimeter) {
      delimeters.add(String.valueOf(delimeter));
    }
}
