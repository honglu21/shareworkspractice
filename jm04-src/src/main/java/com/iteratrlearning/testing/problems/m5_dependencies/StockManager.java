package com.iteratrlearning.testing.problems.m5_dependencies;

import com.iteratrlearning.testing.problems.m2_testing_code.Transaction;

import java.util.HashMap;
import java.util.Map;

public class StockManager
{
    private final long NOTIFICATION_LEVEL = 1L;
    private final Map<String, Long> stockLevels = new HashMap<>();
    private NoticeService noticeService;

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

        notifySale(productName, remainingStock);
    }

    public String notifySale(String productName, long remainingStock) {
        StringBuilder builder = new StringBuilder();
      if (currentStock(productName) <= NOTIFICATION_LEVEL) {
          System.out.println("current stock is go down 1 " + productName + " current stock " + currentStock(productName) + " stock " + remainingStock);
          return builder.append("current stock is go down 1 ").append(productName).append(" current stock ").append(currentStock(productName)).append(" stock ").append(remainingStock).toString();
      }
      return builder.append("no lower stock happen").toString();
    }

    public long currentStock(final String productName)
    {
        return stockLevels.getOrDefault(productName, 0L);
    }
}
