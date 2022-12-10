package com.iteratrlearning.testing.answers.m2_testing_code;

import com.iteratrlearning.testing.problems.m2_testing_code.Transaction;
import com.iteratrlearning.testing.problems.m2_testing_code.TransactionReporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionReporterTest
{
    private static final String APPLE = "Apple";
    private static final String BANANA = "Banana";

    @Test
    public void shouldLookupTotalForProduct()
    {
        // Given
        final TransactionReporter reporter = new TransactionReporter();

        // When
        addAppleTransactions(reporter);

        // Then
        assertTotalIs(APPLE, 5L, reporter);
    }

    @Test
    public void shouldKeepSeparateTotalsForDifferentProducts()
    {
        // Given
        final TransactionReporter reporter = new TransactionReporter();

        // When
        addAppleTransactions(reporter);

        // Then
        reporter.addTransaction(new Transaction(BANANA, 2L));

        assertTotalIs(APPLE, 5L, reporter);
        assertTotalIs(BANANA, 2L, reporter);
    }

    @Test
    public void shouldLookupZeroForEmptyReport()
    {
        // Given
        final TransactionReporter reporter = new TransactionReporter();

        // Then
        assertTotalIs(APPLE, 0L, reporter);
    }

    private void assertTotalIs(
        final String productName, final long expectedTotal, final TransactionReporter reporter)
    {
        assertEquals(expectedTotal, reporter.getTotal(productName));
    }

    private void addAppleTransactions(final TransactionReporter reporter)
    {
        reporter.addTransaction(new Transaction(APPLE, 2));
        reporter.addTransaction(new Transaction(APPLE, 3));
    }
}
