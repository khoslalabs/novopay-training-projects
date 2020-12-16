package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialYearSummary;

public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("Database Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("Database Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("Database Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database Writer => appendFinancialMonthSummary");
    }
}
