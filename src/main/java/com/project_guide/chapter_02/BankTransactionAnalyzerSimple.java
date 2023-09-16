package main.java.com.project_guide.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";


    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        final double total = calculateTotalAmount(bankTransactions);
        System.out.println("The total for all transactions is " + total);

        final List<BankTransaction> bankTransactionsInJanuary = selectInMonth(bankTransactions, Month.JANUARY);
        final double totalJanuary = calculateTotalAmount(bankTransactionsInJanuary);
        System.out.println("The total for all transactions in January is " + totalJanuary);
    }

    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.amount();
        }
        return total;
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.date().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
