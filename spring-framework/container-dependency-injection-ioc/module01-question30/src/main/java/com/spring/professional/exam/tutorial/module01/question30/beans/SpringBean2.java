package com.spring.professional.exam.tutorial.module01.question30.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {
    @Value("3")
    private int taxId;

    @Value("#{${app.tax.value}/100.0}")
    private float taxValue;

    public int getTaxId() {
        return taxId;
    }

    public float getTaxValue() {
        return taxValue;
    }
}
