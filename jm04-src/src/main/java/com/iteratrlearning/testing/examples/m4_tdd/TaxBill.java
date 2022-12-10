package com.iteratrlearning.testing.examples.m4_tdd;

public class TaxBill {
    private final double averageRateOfTax;


    private final int owedTax;

    public TaxBill(double averageRateOfTax, int owedTax) {
        this.averageRateOfTax = averageRateOfTax;
        this.owedTax = owedTax;
    }


    public double getAverageRateOfTax() {
        return averageRateOfTax;
    }

    public int getOwedTax() {
        return owedTax;
    }


}
