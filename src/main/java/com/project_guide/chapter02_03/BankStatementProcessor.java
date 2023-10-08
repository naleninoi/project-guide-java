package com.project_guide.chapter02_03;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final IBankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalAmount() {
        return summarizeTransactions((acc, bankTransaction) -> acc + bankTransaction.amount());
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.date().getMonth() == month ? acc + bankTransaction.amount() : acc);
    }

    public double calculateTotalInCategory(final String category) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.description().equalsIgnoreCase(category) ? acc + bankTransaction.amount() : acc);
    }

    public List<BankTransaction> findTransactions(final IBankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.amount() >= amount);
    }
}
