package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.dao;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialMonthSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialQuarterSummary;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.bean.method.level.ds.FinancialYearSummary;

public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Database Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}
