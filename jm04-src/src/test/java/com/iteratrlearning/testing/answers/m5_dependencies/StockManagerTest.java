package com.iteratrlearning.testing.answers.m5_dependencies;

import com.iteratrlearning.testing.problems.m2_testing_code.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class StockManagerTest
{
    private static final String APPLE = "Apple";
    private static final String BANANA = "Banana";

    private NotificationService notificationService = mock(NotificationService.class);
    private StockManager stockManager = new StockManager(notificationService);

    @Test
    public void shouldOnlyAcceptTransactionsWhenInStock()
    {
        assertThrows(IllegalArgumentException.class, () -> sellTwoApples());
    }

    @Test
    public void shouldCalculateStockUpdates()
    {
        stockManager.onStockDelivered(APPLE, 4);
        stockManager.onStockDelivered(BANANA, 3);

        sellTwoApples();
        stockManager.onNewSale(new Transaction(BANANA, 1));

        assertStock(APPLE, 2L);
        assertStock(BANANA, 2L);
    }

    @Test
    public void shouldNotifyOwnerWhenStockTooLow()
    {
        stockManager.onStockDelivered(APPLE, 3);

        sellTwoApples();

        assertStock(APPLE, 1L);

        notificationService.onLowStock(APPLE, 1L);
    }

    private void assertStock(final String productName, final long expectedStock)
    {
        assertEquals(expectedStock, stockManager.currentStock(productName));
    }

    private void sellTwoApples()
    {
        stockManager.onNewSale(new Transaction(APPLE, 2));
    }
}
