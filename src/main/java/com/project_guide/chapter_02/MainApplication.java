package com.project_guide.chapter_02;

import java.io.IOException;

public class MainApplication {


    public static void main(String[] args) throws IOException {

        final String fileName = args[0];
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze(fileName, bankStatementParser);
    }
}
