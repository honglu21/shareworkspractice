package com.iteratrlearning.testing.answers.m2_testing_code;

import com.iteratrlearning.testing.problems.m2_testing_code.StringSplitter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringSplitterTest
{

    private static final List<String> EXPECTED_LIST = Arrays.asList("Richard", "Raoul");

    @Test
    public void shouldReturnEmptyListForEmptyString()
    {
        final List<String> result = StringSplitter.splitByColon("");

        assertTrue(result.isEmpty(), result + " was not empty");
    }

    @Test
    public void shouldReturnColonSeparatedListOfStrings()
    {
        final List<String> result = StringSplitter.splitByColon("Richard:Raoul");

        assertEquals(EXPECTED_LIST, result);
    }

    @Test
    public void shouldFilterEmptyMiddleStrings()
    {
        final List<String> result = StringSplitter.splitByColon(":Richard::Raoul");

        assertEquals(EXPECTED_LIST, result);
    }
}
