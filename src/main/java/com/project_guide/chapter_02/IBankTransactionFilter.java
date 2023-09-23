package com.project_guide.chapter_02;

@FunctionalInterface
public interface IBankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
