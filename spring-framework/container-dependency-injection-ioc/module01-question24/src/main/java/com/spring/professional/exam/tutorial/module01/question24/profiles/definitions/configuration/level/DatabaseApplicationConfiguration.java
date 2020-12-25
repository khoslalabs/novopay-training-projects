package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.FinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {
    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }
}
