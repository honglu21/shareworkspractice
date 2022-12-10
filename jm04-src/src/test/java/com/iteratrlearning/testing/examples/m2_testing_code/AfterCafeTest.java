package com.iteratrlearning.testing.examples.m2_testing_code;

import org.junit.jupiter.api.Test;

import static com.iteratrlearning.testing.examples.m2_testing_code.CoffeeType.Espresso;
import static com.iteratrlearning.testing.examples.m2_testing_code.CoffeeType.Latte;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AfterCafeTest
{

    @Test
    public void canBrewEspresso() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        assertEquals(7, coffee.getBeans());
        assertEquals(0, coffee.getMilk());
        assertEquals(Espresso, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(0, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(227);

        // when
        Coffee coffee = cafe.brew(Latte);

        // then
        assertEquals(Latte, coffee.getType());
    }

    @Test
    public void mustRestockMilk() {
        // given
        Cafe cafe = new Cafe();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> cafe.restockMilk(0));
    }

    @Test
    public void mustRestockBeans() {
        // given
        Cafe cafe = new Cafe();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> cafe.restockBeans(0));
    }

    @Test
    public void lattesRequireMilk() {
        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when, then
        assertThrows(IllegalStateException.class, () -> cafe.brew(Latte));
    }

}
