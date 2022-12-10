package com.iteratrlearning.testing.examples.m4_tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest
{
    // a year is a leap year if it is divisible by four
    // but, years divisible by 100, are not leap years,
    // except years divisible by 400


    @Test
    public void isLeapYearDividedByfour() {
        int year = 2020;
        Assertions.assertEquals(true, LeapYear.isleap(year));
    }

    @Test
    public void isLeapYearDividedBy400() {
        int year = 2000;
        Assertions.assertEquals(true, LeapYear.isleap(year));
    }

    @Test
    public void isLeapYearDividedBy100NotBy4() {
        int year = 700;
        Assertions.assertEquals(false, LeapYear.isleap(year));
    }

    @Test
    public void isLeapYearNotDividedBy100NotBy4NotBy400() {
        int year = 2013;
        Assertions.assertEquals(false, LeapYear.isleap(year));
    }

}
