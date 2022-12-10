package com.iteratrlearning.testing.problems.m2_testing_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// TODO: Write test code to StringSplitter.splitByColon() method
// TODO: consider different cases to test and use the Javadoc of the method to confirm the
// Specification of the class.
public class StringSplitterTest
{
    @Test
    public void testStringSplitter_whenString_hasLength_withColon() {
        String input = ":Hello::World!";
        List<String> actual = StringSplitter.splitByColon(input);
        List<String> expected = new ArrayList<>();
        expected.add("Hello");
        expected.add("World!");
        System.out.println(actual + " " + expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStringSplitter_whenString_empty() {
        String input = "";
        List<String> actual = StringSplitter.splitByColon(input);
        List<String> expected = new ArrayList<>();

        System.out.println(actual + " " + expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStringSplitter_whenString_hasWildchar_withColon() {
        String input = "##!@:457()$$";
        List<String> actual = StringSplitter.splitByColon(input);
        List<String> expected = new ArrayList<>();
        expected.add("##!@");
        expected.add("457()$$");
        System.out.println(actual + " " + expected);
        Assertions.assertEquals(expected, actual);
    }

}
