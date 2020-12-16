package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.FileStoreFinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.FinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.FileStoreFinancialReportWriter;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileApplicationConfiguration {
    @Bean
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }
}
