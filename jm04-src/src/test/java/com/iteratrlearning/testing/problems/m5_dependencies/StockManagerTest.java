package com.iteratrlearning.testing.problems.m5_dependencies;

import com.iteratrlearning.testing.problems.m2_testing_code.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO: when stock levels get down to 1 make the StockManager notify an owner that
// they need to buy more stock. You need to add a NotificationService to model the notification.
//
// NB: You don't need to implement the notification, just ensure that a method gets called.
public class StockManagerTest
{
    private static final String APPLE = "Apple";
    private static final String BANANA = "Banana";

    private StockManager stockManager = new StockManager();

    @Test
    public void shouldOnlyAcceptTransactionsWhenInStock()
    {
        assertThrows(IllegalArgumentException.class, () ->  sellProducts(APPLE, 2));
    }

    @Test
    public void shouldCalculateStockUpdates()
    {
        stockManager.onStockDelivered(APPLE, 4);
        stockManager.onStockDelivered(BANANA, 3);

        sellProducts(APPLE, 2);
        stockManager.onNewSale(new Transaction(BANANA, 1));

        assertStock(APPLE, 2L);
        assertStock(BANANA, 2L);
    }

    @Test
    public void shouldNotifyWhenStockGoDown()
    {
        stockManager.onStockDelivered(APPLE, 3);
        stockManager.onStockDelivered(BANANA, 2);

        sellProducts(APPLE, 2);
        sellProducts(BANANA, 1);

        assertStock(APPLE, 1L);
        assertStock(BANANA, 1L);
        assertNotify(APPLE, 1L);
    }



    private void assertStock(final String productName, final long expectedStock)
    {
        assertEquals(expectedStock, stockManager.currentStock(productName));
    }

    private void assertNotify(String productName, long remaining)
    {
        Assertions.assertTrue(stockManager.notifySale(productName, remaining).contains(productName));
        //Assertions.assertEquals(stockManager.notifySale(productName, remaining).contains(String.remaining);
    }

    private void sellProducts(String productName, int amount)
    {
        stockManager.onNewSale(new Transaction(productName, amount));
    }

}
