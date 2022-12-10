package com.iteratrlearning.testing.examples.m4_tdd;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaxReturnAfter
{
    public static final int PERSONAL_ALLOWANCE = 10_000;
    public static final int BASIC_RATE_LIMIT = 50_000;
    public static final int PERSONAL_ALLOWANCE_REDUCTION_LEVEL = 100_000;

    private static final int BASIC_RATE_QUANTITY = BASIC_RATE_LIMIT - PERSONAL_ALLOWANCE;
    private static final double BASIC_RATE = 0.2;
    private static final double HIGHER_RATE = 0.4;

    private int grossIncome;
    private int taxPaidAsPaye;

    public TaxReturnAfter(final int grossIncome, final int taxPaidAsPaye)
    {
        this.grossIncome = grossIncome;
        this.taxPaidAsPaye = taxPaidAsPaye;
    }

    public TaxBillAfter calculateTax()
    {
        final int personalAllowanceReduction =
            max(0, grossIncome - PERSONAL_ALLOWANCE_REDUCTION_LEVEL) / 2;
        final int personalAllowance = PERSONAL_ALLOWANCE - personalAllowanceReduction;

        final int incomeAfterAllowance = grossIncome - personalAllowance;
        final int basicRateIncome = min(incomeAfterAllowance, BASIC_RATE_QUANTITY);
        final int higherRateIncome = max(0, incomeAfterAllowance - BASIC_RATE_QUANTITY);


        final int totalTax = (int) (basicRateIncome * BASIC_RATE + higherRateIncome * HIGHER_RATE);
        final double averageRateOfTax = (double) totalTax / grossIncome;

        final int owedTax = totalTax - taxPaidAsPaye;
        return new TaxBillAfter(averageRateOfTax, owedTax);
    }
}
