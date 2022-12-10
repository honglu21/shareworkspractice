package com.iteratrlearning.testing.examples.m4_tdd;

public class TaxBillAfter
{
    private final double averageRateOfTax;
    private final int owedTax;

    public TaxBillAfter(final double averageRateOfTax, final int owedTax)
    {
        this.averageRateOfTax = averageRateOfTax;
        this.owedTax = owedTax;
    }

    public double getAverageRateOfTax()
    {
        return averageRateOfTax;
    }

    public int getOwedTax()
    {
        return owedTax;
    }
}
