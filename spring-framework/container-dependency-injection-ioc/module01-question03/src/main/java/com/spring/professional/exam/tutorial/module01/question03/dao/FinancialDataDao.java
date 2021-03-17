package com.spring.professional.exam.tutorial.module01.question03.dao;

import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
