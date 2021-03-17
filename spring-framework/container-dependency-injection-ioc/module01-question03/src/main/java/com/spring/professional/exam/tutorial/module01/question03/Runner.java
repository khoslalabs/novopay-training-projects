package com.spring.professional.exam.tutorial.module01.question03;

import com.spring.professional.exam.tutorial.module01.question03.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);

        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);

        financialReportService.generateReport();
    }
}
