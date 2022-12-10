package com.iteratrlearning.testing.answers.m5_dependencies;

import com.iteratrlearning.testing.problems.m2_testing_code.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StockManager
{
    private static final int STOCK_NOTIFICATION_LEVEL = 1;

    private final Map<String, Long> stockLevels = new HashMap<>();

    private final NotificationService notificationService;

    public StockManager(final NotificationService notificationService)
    {
        Objects.requireNonNull(notificationService);

        this.notificationService = notificationService;
    }

    public void onStockDelivered(final String productName, final long amount)
    {
        final long stock = currentStock(productName);

        stockLevels.put(productName, stock + amount);
    }

    public void onNewSale(final Transaction transaction)
    {
        final String productName = transaction.getProductName();
        final long amount = transaction.getAmount();

        final long stock = currentStock(productName);
        if (stock < amount)
        {
            throw new IllegalArgumentException(
                "Cannot process transaction, " + stock + " in stock, needed: " + amount);
        }

        final long remainingStock = stock - amount;
        stockLevels.put(productName, remainingStock);

        if (remainingStock <= STOCK_NOTIFICATION_LEVEL)
        {
            notificationService.onLowStock(productName, remainingStock);
        }
    }

    public long currentStock(final String productName)
    {
        return stockLevels.getOrDefault(productName, 0L);
    }
}
