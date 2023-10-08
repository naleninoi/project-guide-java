package com.project_guide;

import com.project_guide.chapter02_03.BankStatementAnalyzer;
import com.project_guide.chapter02_03.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {


    public static void main(String[] args) throws IOException {

        final String fileName = args[0];
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze(fileName, bankStatementParser);
    }
}
