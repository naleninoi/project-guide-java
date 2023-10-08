package com.project_guide.chapter02_03;

public class HtmlExporter implements IExporter {
    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>" +
                "<html lang='en'>" +
                "<head><title>Bank Transaction Report</title></head>" +
                "<body>" +
                "<ul>" +
                "<li><strong>The sum is</strong>" + summaryStatistics.sum() + "<li>" +
                "<li><strong>The average is</strong>" + summaryStatistics.average() + "<li>" +
                "<li><strong>The max is</strong>" + summaryStatistics.max() + "<li>" +
                "<li><strong>The min is</strong>" + summaryStatistics.min() + "<li>" +
                "</ul>" +
                "</body>" +
                "</html>";

        return result;
    }
}
