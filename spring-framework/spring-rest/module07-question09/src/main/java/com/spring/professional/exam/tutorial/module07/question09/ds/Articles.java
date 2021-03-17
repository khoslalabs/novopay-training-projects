package com.spring.professional.exam.tutorial.module07.question09.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JacksonXmlRootElement(localName = "articles")
public class Articles {

    @JacksonXmlProperty(localName = "articles")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Article> articles = new LinkedList<>();

    @SuppressWarnings("unused")
    public Articles() {
    }

    public Articles(Iterable<Article> customers) {
        this.articles = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }
}
