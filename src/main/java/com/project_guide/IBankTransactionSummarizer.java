package com.project_guide;

@FunctionalInterface
public interface IBankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
