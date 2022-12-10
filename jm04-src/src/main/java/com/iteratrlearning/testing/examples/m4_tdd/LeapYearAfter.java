package com.iteratrlearning.testing.examples.m4_tdd;

public class LeapYearAfter
{

    public static boolean isLeap(final int year) {
        return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
    }

    private static boolean isDivisible(int value, int denominator) {
        return value % denominator == 0;
    }

}
