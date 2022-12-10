package com.iteratrlearning.testing.examples.m4_tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearAfterTest
{

    // a year is a leap year if it is divisible by four
    // but, years divisible by 100, are not leap years,
    // except years divisible by 400

    @Test
    public void leapYearsAreDivisibleByFour() {
        assertTrue(LeapYearAfter.isLeap(2016));
    }

    @Test
    public void normalYearIsNotDivisibleByFour() {
        assertFalse(LeapYearAfter.isLeap(3));
    }

    @Test
    public void yearsDivisibleBy100AreNotLeapYears() {
        assertFalse(LeapYearAfter.isLeap(1900));
    }

    @Test
    public void yearsDivisibleBy400AreLeapYears() {
        assertTrue(LeapYearAfter.isLeap(2000));
    }

}
