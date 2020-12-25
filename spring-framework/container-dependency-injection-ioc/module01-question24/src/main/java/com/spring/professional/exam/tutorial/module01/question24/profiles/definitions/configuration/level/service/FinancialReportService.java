package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.service;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.FinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.ds.FinancialYearSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {

    private final FinancialDataDao financialDataDao;
    private final FinancialReportWriter financialReportWriter;

    public FinancialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    public void generateReport() {
        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);
        FinancialQuarterSummary financialQuarterSummary = financialDataDao.findFinancialQuarterSummary(2019, 1);
        FinancialMonthSummary financialMonthSummary = financialDataDao.findFinancialMonthSummary(2019, 4);

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report");
        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
        financialReportWriter.appendFinancialQuarterSummary(financialQuarterSummary);
        financialReportWriter.appendFinancialMonthSummary(financialMonthSummary);
    }
}
