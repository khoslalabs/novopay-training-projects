package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.writer;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
