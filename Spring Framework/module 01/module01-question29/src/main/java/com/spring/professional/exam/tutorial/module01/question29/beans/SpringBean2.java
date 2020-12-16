package com.spring.professional.exam.tutorial.module01.question29.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {
    @Value("3")
    private int taxId;

    @Value("#{${app.tax.value}/100.0}")
    private float taxValue;

    @Value("${app.tax.department.name}")
    private String taxDepartmentName;

    @Value("${app.tax.department.alt.name:no_name}")
    private String taxDepartmentAlternateName;

    public int getTaxId() {
        return taxId;
    }

    public float getTaxValue() {
        return taxValue;
    }

    public String getTaxDepartmentName() {
        return taxDepartmentName;
    }

    public String getTaxDepartmentAlternateName() {
        return taxDepartmentAlternateName;
    }
}
