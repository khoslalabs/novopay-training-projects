package com.spring.professional.exam.tutorial.module03.question03.template.design.pattern;

import com.spring.professional.exam.tutorial.module03.question03.template.design.pattern.report.PdfReport;
import com.spring.professional.exam.tutorial.module03.question03.template.design.pattern.report.TxtReport;
import com.spring.professional.exam.tutorial.module03.question03.template.design.pattern.report.XlsReport;

import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {
        new PdfReport()
                .generateReport(Paths.get("report.pdf"), "report content");

        new XlsReport()
                .generateReport(Paths.get("report.xls"), "report content");

        new TxtReport()
                .generateReport(Paths.get("report.txt"), "report content");
    }
}
