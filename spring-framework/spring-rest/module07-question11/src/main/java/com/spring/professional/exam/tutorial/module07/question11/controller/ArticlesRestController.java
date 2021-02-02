package com.spring.professional.exam.tutorial.module07.question11.controller;

import com.spring.professional.exam.tutorial.module07.question11.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module07.question11.ds.Article;
import com.spring.professional.exam.tutorial.module07.question11.ds.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticlesRestController {

    @Autowired
    private ArticlesDao articlesDao;

    // curl localhost:8080/api/articles |jq
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Article>> listArticlesJSON() {
        return ResponseEntity.ok()
                .body(articlesDao.findAll());
    }

    // curl -H 'Accept: application/xml' localhost:8080/api/articles |xml_pp
    @RequestMapping(method = GET, produces = APPLICATION_XML_VALUE)
    public ResponseEntity<Articles> listArticlesXML() {
        return ResponseEntity.ok()
                .body(new Articles(articlesDao.findAll()));
    }
}
