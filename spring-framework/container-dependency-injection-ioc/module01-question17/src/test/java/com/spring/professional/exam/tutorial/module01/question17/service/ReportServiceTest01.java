package com.spring.professional.exam.tutorial.module01.question17.service;

import com.spring.professional.exam.tutorial.module01.question17.ApplicationConfig;
import com.spring.professional.exam.tutorial.module01.question17.ds.Report;
import com.spring.professional.exam.tutorial.module01.question17.writer.ReportWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ReportServiceTest01 {
    @Autowired
    private ReportService reportService;
    @MockBean
    private ReportWriter reportWriter;

    @Test
    public void shouldPassReportToWriter() {
        reportService.execute();

        verify(reportWriter).write(any(Report.class), any());
    }
}