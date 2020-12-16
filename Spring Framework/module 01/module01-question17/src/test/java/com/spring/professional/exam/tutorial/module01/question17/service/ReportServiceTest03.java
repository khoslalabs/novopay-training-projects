package com.spring.professional.exam.tutorial.module01.question17.service;

import com.spring.professional.exam.tutorial.module01.question17.ds.Report;
import com.spring.professional.exam.tutorial.module01.question17.writer.ReportWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReportServiceTest03 {
    private ReportService reportService;

    @Before
    public void setUp() {
        reportService = new ReportService();
    }

    @Test
    public void shouldPassReportToWriter() {
        ReportWriter reportWriter = Mockito.mock(ReportWriter.class);
        ReflectionTestUtils.setField(reportService, ReportService.class, "reportWriter", reportWriter, ReportWriter.class);

        reportService.execute();

        verify(reportWriter).write(any(Report.class), any());
    }
}