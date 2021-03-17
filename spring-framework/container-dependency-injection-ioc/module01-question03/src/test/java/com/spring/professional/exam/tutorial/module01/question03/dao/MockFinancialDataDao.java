package com.spring.professional.exam.tutorial.module01.question03.dao;

import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialYearSummary;

public class MockFinancialDataDao implements FinancialDataDao {

    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Mock Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Mock Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Mock Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}