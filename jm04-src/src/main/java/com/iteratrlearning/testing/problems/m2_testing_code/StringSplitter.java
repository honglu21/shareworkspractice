package com.iteratrlearning.testing.problems.m2_testing_code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter
{
    /**
     * Splits out the input string separated by colons and return a list where
     * each entry in the list is the substring between the colons. If there are
     * any empty Strings these will not be returned.
     *
     * @param inputString the input string
     * @return the split out result
     */
    public static List<String> splitByColon(final String inputString)
    {
        return Arrays.stream(inputString.split(":"))
                     .filter(str -> !str.isEmpty())
                     .collect(Collectors.toList());
    }
}
