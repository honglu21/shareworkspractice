package com.iteratrlearning.testing.examples.m2_testing_code;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class BeforeCafeTest
{
    // 1.
    // TODO: canBrewEspresso
    @Test
    public void testCanBrewEspresso() {
        Cafe _cafe = new Cafe();
        _cafe.restockBeans(100);
        _cafe.restockMilk(100);
        Coffee espresso = _cafe.brew(CoffeeType.Espresso);
        Assertions.assertEquals(CoffeeType.Espresso, espresso.getType());
        Assertions.assertEquals(CoffeeType.Espresso.getRequiredBeans(), espresso.getBeans());
        Assertions.assertEquals(CoffeeType.Espresso.getRequiredMilk(), espresso.getMilk());
    }

    // 2.
    // TODO: brewingEspressoConsumesBeans
    // TODO: canBrewLatte
    @Test
    public void brewingEspressoConsumesBeans() {
        Cafe _cafe = new Cafe();
        _cafe.restockBeans(100);
        _cafe.restockMilk(100);
        Coffee espresso = _cafe.brew(CoffeeType.Espresso);
        Assertions.assertEquals(100-CoffeeType.Espresso.getRequiredBeans(), _cafe.getBeansInStock());
        Assertions.assertEquals(100-CoffeeType.Espresso.getRequiredMilk(), _cafe.getMilkInStock());
    }

    // 3.
    // TODO: mustRestockMilk
    // TODO: lattesRequireMilk

}
