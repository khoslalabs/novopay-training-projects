package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.dao;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
