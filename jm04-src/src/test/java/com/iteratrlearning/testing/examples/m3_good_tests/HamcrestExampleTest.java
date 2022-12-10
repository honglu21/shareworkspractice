package com.iteratrlearning.testing.examples.m3_good_tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExampleTest
{

    @Test
    public void mapShouldContainValue()
    {
        Map<String, Integer> values = getValues();

        assertThat(values, hasKey("B"));
    }

    private Map<String, Integer> getValues()
    {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        return map;
    }

    @Test
    public void listOrderingIsIrrelevant() {
        List<Integer> numbers = getNumbers();

        assertThat(numbers, hasItem(5));
    }

    @Test
    void contrivedDemoShowAnyOf() {
        int i = getNumbers().get(3);
        assertThat(i, anyOf(is(5), is(7)));
    }

    private List<Integer> getNumbers()
    {
        return Arrays.asList(1, 2, 3, 5, 4);
    }

}
