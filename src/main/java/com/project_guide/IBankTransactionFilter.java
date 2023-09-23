package com.project_guide;

@FunctionalInterface
public interface IBankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
