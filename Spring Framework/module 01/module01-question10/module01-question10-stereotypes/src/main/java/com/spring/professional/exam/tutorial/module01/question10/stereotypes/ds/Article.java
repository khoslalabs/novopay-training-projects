package com.spring.professional.exam.tutorial.module01.question10.stereotypes.ds;

public class Article {
    private int id;

    public Article(int id) {

        this.id = id;
    }

    public String getName() {
        return "Article-" + id;
    }
}
