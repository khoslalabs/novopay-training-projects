package com.spring.professional.exam.tutorial.module01.question10.stereotypes.components;

import com.spring.professional.exam.tutorial.module01.question10.stereotypes.ds.Article;
import com.spring.professional.exam.tutorial.module01.question10.stereotypes.ds.TaxCalculation;
import com.spring.professional.exam.tutorial.module01.question10.stereotypes.ds.TaxRate;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculationComponent {

    public TaxCalculation calculateTax(Article article, TaxRate taxRate) {
        return new TaxCalculation();
    }
}
