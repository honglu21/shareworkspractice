package com.iteratrlearning.testing.examples.m4_tdd;

public class TaxReturnTest
{

    // TODO: Calculate Total Tax owed and average rate of tax as a percentage of gross income.
    // Tax can be accurate to the nearest £.
    public void CalculateTax() {
        int personalAllowance = 10000;
        double basicRate = 0.20;
        double highRate = 0.40;
        double tax = 0;

        if (personalAllowance < 10000 && personalAllowance >=0 ) {
            tax = 0;
        }
         else if ( personalAllowance >= 10000 && personalAllowance < 50000) {
            tax = personalAllowance * basicRate;
        } else if ( personalAllowance >= 50000 && personalAllowance < 100000) {
            tax = personalAllowance * highRate;
        } else {
             tax = Math.max((personalAllowance - 100000)/2, 0);
        }

}

    // Personal Allowance: £10,000
    // Basic Rate: 20%
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
