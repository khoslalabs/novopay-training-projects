package com.spring.professional.exam.tutorial.module01.question17.service;

import com.spring.professional.exam.tutorial.module01.question17.ApplicationConfig;
import com.spring.professional.exam.tutorial.module01.question17.ds.Report;
import com.spring.professional.exam.tutorial.module01.question17.writer.ReportWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static com.spring.professional.exam.tutorial.module01.question17.service.ReportServiceTest04.REPORT_NAME;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TestPropertySource(properties = "report.global.name=" + REPORT_NAME)
public class ReportServiceTest04 {
    static final String REPORT_NAME = "Mock_Report";

    @Autowired
    private ReportService reportService;
    @MockBean
    private ReportWriter reportWriter;

    @Test
    public void shouldPassReportToWriter() {
        reportService.execute();

        verify(reportWriter).write(any(Report.class), eq(REPORT_NAME));
    }
}