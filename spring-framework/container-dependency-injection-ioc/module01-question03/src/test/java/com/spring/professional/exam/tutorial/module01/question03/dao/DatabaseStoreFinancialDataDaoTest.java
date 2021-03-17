package com.spring.professional.exam.tutorial.module01.question03.dao;

import com.spring.professional.exam.tutorial.module01.question03.ds.FinancialYearSummary;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DatabaseStoreFinancialDataDaoTest {

    @Test
    public void shouldCreateFinancialDataDao() {
        FinancialDataDao financialDataDao = new DatabaseStoreFinancialDataDao();

        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);

        assertNotNull(financialYearSummary);
    }
}