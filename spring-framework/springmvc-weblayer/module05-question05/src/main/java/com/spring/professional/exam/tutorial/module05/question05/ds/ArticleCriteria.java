package com.spring.professional.exam.tutorial.module05.question05.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleCriteria {
    private String bodyLike;

    @SuppressWarnings("unused")
    public ArticleCriteria() {
    }
}
