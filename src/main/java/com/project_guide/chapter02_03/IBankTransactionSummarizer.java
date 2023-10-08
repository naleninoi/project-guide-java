package com.project_guide.chapter02_03;

@FunctionalInterface
public interface IBankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
