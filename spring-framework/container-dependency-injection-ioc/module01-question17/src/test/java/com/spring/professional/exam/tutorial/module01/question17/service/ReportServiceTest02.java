package com.spring.professional.exam.tutorial.module01.question17.service;

import com.spring.professional.exam.tutorial.module01.question17.ds.Report;
import com.spring.professional.exam.tutorial.module01.question17.writer.ReportWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest02 {
    @InjectMocks
    private ReportService reportService;
    @Mock
    private ReportWriter reportWriter;

    @Test
    public void shouldPassReportToWriter() {
        reportService.execute();

        verify(reportWriter).write(any(Report.class), any());
    }
}