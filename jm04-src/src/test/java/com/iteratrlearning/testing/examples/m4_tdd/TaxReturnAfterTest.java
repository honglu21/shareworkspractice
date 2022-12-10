package com.iteratrlearning.testing.examples.m4_tdd;

import org.junit.jupiter.api.Test;

import static com.iteratrlearning.testing.examples.m4_tdd.TaxReturnAfter.BASIC_RATE_LIMIT;
import static com.iteratrlearning.testing.examples.m4_tdd.TaxReturnAfter.PERSONAL_ALLOWANCE;
import static com.iteratrlearning.testing.examples.m4_tdd.TaxReturnAfter.PERSONAL_ALLOWANCE_REDUCTION_LEVEL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxReturnAfterTest
{

    // TODO: Calculate Total Tax owed and average rate of tax as a percentage of gross income.
    // Tax can be accurate to the nearest £.

    @Test
    public void shouldCalculateTaxOnPersonalAllowance()
    {
        final TaxReturnAfter taxReturn = new TaxReturnAfter(PERSONAL_ALLOWANCE, 0);

        final TaxBillAfter taxBill = taxReturn.calculateTax();

        assertEquals(0, taxBill.getOwedTax());
        assertEquals(0.0, taxBill.getAverageRateOfTax(), 0.01);
    }

    @Test
    public void shouldCalculateTaxOnBasicRate()
    {
        final TaxReturnAfter taxReturn = new TaxReturnAfter(PERSONAL_ALLOWANCE + 10_000, 0);

        final TaxBillAfter taxBill = taxReturn.calculateTax();

        assertEquals(2_000, taxBill.getOwedTax());
        assertEquals(0.1, taxBill.getAverageRateOfTax(), 0.01);
    }

    @Test
    public void shouldCalculateTaxOnHigherRate()
    {
        final TaxReturnAfter taxReturn = new TaxReturnAfter(
                BASIC_RATE_LIMIT + 10_000, 0);

        final TaxBillAfter taxBill = taxReturn.calculateTax();

        assertEquals(12_000, taxBill.getOwedTax());
        assertEquals(0.20, taxBill.getAverageRateOfTax(), 0.01);
    }

    @Test
    public void shouldCalculatePersonRateCrushing()
    {
        final TaxReturnAfter taxReturn = new TaxReturnAfter(
                PERSONAL_ALLOWANCE_REDUCTION_LEVEL + 10_000, 0);

        final TaxBillAfter taxBill = taxReturn.calculateTax();

        assertEquals(34000, taxBill.getOwedTax());
        assertEquals(0.31, taxBill.getAverageRateOfTax(), 0.01);
    }

    @Test
    public void shouldCalculatePayeOffSet()
    {
        final TaxReturnAfter taxReturn = new TaxReturnAfter(
                PERSONAL_ALLOWANCE_REDUCTION_LEVEL + 10_000, 31_000);

        final TaxBillAfter taxBill = taxReturn.calculateTax();

        assertEquals(3000, taxBill.getOwedTax());
        assertEquals(0.31, taxBill.getAverageRateOfTax(), 0.01);
    }

    // Basic Rate: 20%
    // Personal Allowance: £10,000
    // Higher Rate: > £50,000 - 40%

    // The Personal Allowance goes down by £1 for every £2 of income above the £100,000 limit.
    // It can go down to zero, no lower.

    // Your Employer may have paid some amount of your tax already as part of the PAYE
    // System.

    // Examples from Accountant
    // 10,000 - 0, 0
    // 20,000 - 2000, 10%
    // 60,000 - 12,000, 20%
    // 110,000 - 34,000, 31%
}
