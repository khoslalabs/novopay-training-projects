package com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level;

import com.spring.professional.exam.tutorial.module01.question24.profiles.definitions.configuration.level.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        // Activate profile
        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);

        financialReportService.generateReport();
    }
}
