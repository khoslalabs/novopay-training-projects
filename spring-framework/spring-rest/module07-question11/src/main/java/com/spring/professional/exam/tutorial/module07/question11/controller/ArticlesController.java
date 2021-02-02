package com.spring.professional.exam.tutorial.module07.question11.controller;

import com.spring.professional.exam.tutorial.module07.question11.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module07.question11.ds.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class ArticlesController {

    @Autowired
    private ArticlesDao articlesDao;

    // http://localhost:8080/articles
    @GetMapping("/articles")
    public ModelAndView listArticles() {
        return new ModelAndView(
                "index",
                Collections.singletonMap("articles", articlesDao.findAll())
        );
    }

    // http://localhost:8080/articlesResponseBody
    // curl -H 'Accept: application/json' localhost:8080/articlesResponseBody |jq
    // curl -H 'Accept: application/xml' localhost:8080/articlesResponseBody |xml_pp
    @GetMapping("/articlesResponseBody")
    @ResponseBody
    public Iterable<Article> listArticlesResponseBody() {
        return articlesDao.findAll();
    }

    // http://localhost:8080/articlesWithoutResponseBody
    @GetMapping("/articlesWithoutResponseBody")
    public Iterable<Article> listArticlesWithoutResponseBody() {
        return articlesDao.findAll();
    }
}
