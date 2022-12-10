package com.iteratrlearning.testing.examples.m4_tdd;

public class LeapYear {
    public static boolean isleap(final int year) {
        return isDivisible(year, 400) || isDivisible(year, 4) && !isDivisible(year, 100);
    }

    private static boolean isDivisible(int year, int value) {
        return year%value == 0;
    }
}
