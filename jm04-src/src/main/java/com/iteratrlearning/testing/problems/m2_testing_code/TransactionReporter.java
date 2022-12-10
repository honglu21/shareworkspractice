package com.iteratrlearning.testing.problems.m2_testing_code;

import java.util.HashMap;
import java.util.Map;

public class TransactionReporter
{
    private final Map<String, Long> productNameToTotal = new HashMap<>();

    public void addTransaction(final Transaction transaction)
    {
        final String productName = transaction.getProductName();
        final long previousTotal = getTotal(productName);

        productNameToTotal.put(productName, previousTotal + transaction.getAmount());
    }

    public long getTotal(final String productName)
    {
        return productNameToTotal.getOrDefault(productName, 0L);
    }
}
