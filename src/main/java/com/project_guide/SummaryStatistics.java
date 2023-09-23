package com.project_guide;

public record SummaryStatistics
        (double sum, double max, double min, double average) {

    @Override
    public String toString() {
        return "SummaryStatistics{" +
                "sum=" + sum +
                ", max=" + max +
                ", min=" + min +
                ", average=" + average +
                '}';
    }
}
