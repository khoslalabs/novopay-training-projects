package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.custom.annotation.writer;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.custom.annotation.annotations.FileProfile;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.custom.annotation.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.custom.annotation.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.custom.annotation.ds.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@FileProfile
class FileStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("File Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("File Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("File Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File Writer => appendFinancialMonthSummary");
    }
}
