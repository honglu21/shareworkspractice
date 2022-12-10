package com.iteratrlearning.testing.problems.m2_testing_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Write tests for the TransactionReporter class using the following structure
// TODO: fill in each given/when/then clause as appropriate to make yourself familiar
// with the structure.
public class TransactionReporterTest
{
    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;
    TransactionReporter transactionReporter;

    @BeforeEach
    public void setUp() {
        transaction1 = new Transaction("Product 1", 100L);
        transaction2 = new Transaction("Product 2", 120L);
        transaction3 = new Transaction("Product 3", 90L);
        transactionReporter = new TransactionReporter();
    }


    @Test
    public void shouldLookupTotalForProduct()
    {
        // Given
        // TODO


        // When
        // TODO
        transactionReporter.addTransaction(transaction1);

        // Then
        // TODO
        assertEquals(transaction1.getAmount(),transactionReporter.getTotal(transaction1.getProductName()));
        assertTotalIs(transaction1.getProductName(), transaction1.getAmount(), transactionReporter);

    }

    @Test
    public void shouldKeepSeparateTotalsForDifferentProducts()
    {
        // Given
        // TODO

        // When
        // TODO
        transactionReporter.addTransaction(transaction1);
        transactionReporter.addTransaction(transaction2);
        transactionReporter.addTransaction(transaction3);

        // Then
        // TODO
        assertEquals(transaction1.getAmount(),transactionReporter.getTotal(transaction1.getProductName()));
        assertEquals(transaction2.getAmount(),transactionReporter.getTotal(transaction2.getProductName()));
        assertEquals(transaction3.getAmount(),transactionReporter.getTotal(transaction3.getProductName()));
    }

    @Test
    public void shouldLookupZeroForEmptyReport()
    {
        // Given
        // TODO

        // Then
        // TODO
        assertEquals(0L, transactionReporter.getTotal(transaction1.getProductName()));
    }

    private void assertTotalIs(final String productName, final long expectedTotal, final TransactionReporter report) {
        assertEquals(expectedTotal, report.getTotal(productName));
    }
}
