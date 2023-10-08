package com.project_guide.chapter02_03;

@FunctionalInterface
public interface IBankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
