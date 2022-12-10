package com.iteratrlearning.testing.examples.m4_tdd;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaxReturn {
    public static final int PERSONAL_ALLOWANCE = 10_000;
    public static final int BASIC_RATE_LIMIT = 50_000;
    public static final int PERSONAL_ALLOWANCE_REDUCTION_LEVEL = 100_000;

    private static final int BASIC_RATE_QUANTITY = BASIC_RATE_LIMIT - PERSONAL_ALLOWANCE;
    private static final double BASIC_RATE = 0.2;
    private static final double HIGHER_RATE = 0.4;

    private int grossIncome;

    private int taxPaidAsPay;

    public TaxReturn(int grossIncome, int taxPaidAsPay) {
        this.grossIncome = grossIncome;
        this.taxPaidAsPay = taxPaidAsPay;
    }

    public TaxBill calculate() {
        int personalAllowanceReduction = max(0, grossIncome - PERSONAL_ALLOWANCE_REDUCTION_LEVEL)/2;
        final int personalAllowance = PERSONAL_ALLOWANCE - personalAllowanceReduction;
        final int incomeAfterAllowance = grossIncome - personalAllowance;
        final int basicRateIncome = min(incomeAfterAllowance, BASIC_RATE_LIMIT);
        final int highRateIncome = max(0, incomeAfterAllowance - BASIC_RATE_QUANTITY);

        int totalTax = (int)(basicRateIncome * 0.2 + highRateIncome * 0.4);
        double averageRateOfTax = totalTax/grossIncome;
        int owedTax = totalTax - taxPaidAsPay;

        return new TaxBill(averageRateOfTax, owedTax);
    }

    public int getGrossIncome() {
        return grossIncome;
    }

    public int getTaxPaidAsPay() {
        return taxPaidAsPay;
    }

}
