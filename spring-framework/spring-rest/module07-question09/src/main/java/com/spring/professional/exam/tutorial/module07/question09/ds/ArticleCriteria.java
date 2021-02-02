package com.spring.professional.exam.tutorial.module07.question09.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
public class ArticleCriteria {
    private String bodyLike;

    @SuppressWarnings("unused")
    public ArticleCriteria() {
    }

    public String getBodyLike() {
        return bodyLike;
    }

    public void setBodyLike(String bodyLike) {
        this.bodyLike = bodyLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCriteria that = (ArticleCriteria) o;
        return Objects.equals(bodyLike, that.bodyLike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyLike);
    }

    @Override
    public String toString() {
        return "ArticleCriteria{" +
                "bodyLike='" + bodyLike + '\'' +
                '}';
    }
}
