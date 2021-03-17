package com.spring.professional.exam.tutorial.module01.question03.service;

import com.spring.professional.exam.tutorial.module01.question03.dao.FinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialYearSummary;
import com.spring.professional.exam.tutorial.module01.question03.writer.FinancialReportWriter;

class SimpleFinancialReportService {
    private final FinancialDataDao financialDataDao;
    private final FinancialReportWriter financialReportWriter;

    SimpleFinancialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        this.financialDataDao = financialDataDao;
        this.financialReportWriter = financialReportWriter;
    }

    void generateReport() {
        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);

        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
    }
}
