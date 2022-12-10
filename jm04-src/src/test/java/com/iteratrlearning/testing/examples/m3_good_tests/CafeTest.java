package com.iteratrlearning.testing.examples.m3_good_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.iteratrlearning.testing.examples.m3_good_tests.CoffeeType.Espresso;
import static com.iteratrlearning.testing.examples.m3_good_tests.CoffeeType.Latte;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CafeTest {

    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    private Cafe cafe;

    @BeforeEach
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspresso() {
        // given
        withBeans();

        // when
        Coffee coffee = cafe.brew(Espresso);

        // then
        assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
        assertEquals(NO_MILK, coffee.getMilk(), "Wrong amount of milk");
        assertEquals(Espresso, coffee.getType(), "Wrong coffee type");
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // given
        withBeans();

        // when
        cafe.brew(Espresso);

        // then
        assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        // given
        withBeans();
        cafe.restockMilk(Latte.getRequiredMilk());

        // when
        Coffee coffee = cafe.brew(Latte);

        // then
        assertEquals(Latte, coffee.getType(), "Wrong coffee type");
    }

    @Test
    public void mustRestockMilk() {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> cafe.restockMilk(NO_MILK));
    }

    @Test
    public void mustRestockBeans() {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> cafe.restockBeans(NO_BEANS));
    }

    @Test
    public void lattesRequireMilk() {
        // given
        withBeans();

        // when, then
        assertThrows(IllegalStateException.class, () -> cafe.brew(Latte));
    }

    private void withBeans()
    {
        cafe.restockBeans(ESPRESSO_BEANS);
    }

}
