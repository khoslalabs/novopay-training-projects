package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.dao.FinancialDataDao;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.service.FinancialReportService;
import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseApplicationConfiguration.class, FileApplicationConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }
}
