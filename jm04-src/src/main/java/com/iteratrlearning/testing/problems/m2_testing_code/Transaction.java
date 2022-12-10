package com.iteratrlearning.testing.problems.m2_testing_code;

public class Transaction
{
    private final String productName;
    private final long amount;

    public Transaction(final String productName, final long amount)
    {
        this.productName = productName;
        this.amount = amount;
    }

    public String getProductName()
    {
        return productName;
    }

    public long getAmount()
    {
        return amount;
    }
}
