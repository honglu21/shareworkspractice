package com.iteratrlearning.testing.answers.m5_dependencies;

public interface NotificationService
{
    void onLowStock(final String productName, final long remainingStock);
}
