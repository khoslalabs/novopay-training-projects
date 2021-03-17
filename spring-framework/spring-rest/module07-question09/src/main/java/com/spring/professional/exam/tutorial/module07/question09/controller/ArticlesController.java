package com.spring.professional.exam.tutorial.module07.question09.controller;

import com.spring.professional.exam.tutorial.module07.question09.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module07.question09.ds.Article;
import com.spring.professional.exam.tutorial.module07.question09.ds.ArticleCriteria;
import com.spring.professional.exam.tutorial.module07.question09.ds.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    @Autowired
    private ArticlesDao articlesDao;

    // curl localhost:8080/articles |jq
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Article>> listArticlesJSON() {
        return ResponseEntity.ok()
                .body(articlesDao.findAll());
    }

    // curl -H 'Accept: application/xml' localhost:8080/articles |xml_pp
    @RequestMapping(method = GET, produces = APPLICATION_XML_VALUE)
    public ResponseEntity<Articles> listArticlesXML() {
        return ResponseEntity.ok()
                .body(new Articles(articlesDao.findAll()));
    }

    // curl -I localhost:8080/articles
    @RequestMapping(method = HEAD, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Article>> getArticlesCount() {
        return ResponseEntity.ok()
                .header("Articles-Count", String.valueOf(articlesDao.count()))
                .body(articlesDao.findAll());
    }

    // curl localhost:8080/articles/2 |jq
    @RequestMapping(method = GET, path = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        return articlesDao.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());

    }

    // curl -X POST localhost:8080/articles/search -H 'Content-Type: application/json' -d '{"bodyLike": "%some%"}' |jq
    @RequestMapping(method = POST, value = "search", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> searchArticleByCriteria(@RequestBody ArticleCriteria articleCriteria) {
        return ResponseEntity.ok()
                .body(articlesDao.findByBodyLikeIgnoreCase(articleCriteria.getBodyLike()));
    }

    // curl -v -X POST localhost:8080/articles -H 'Content-Type: application/json' -d '{"title": "New article", "body": "New article content"}'
    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articlesDao.save(article);

        return ResponseEntity.ok().body(savedArticle);
    }

    // curl -v -X PUT localhost:8080/articles -H 'Content-Type: application/json' -d '[{"title": "New article 1", "body": "New article content 1"}, {"title": "New article 2", "body": "New article content 2"}]'
    @RequestMapping(method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Article>> updateArticles(@RequestBody List<Article> articles) {
        articlesDao.deleteAll();
        Iterable<Article> savedArticles = articlesDao.saveAll(articles);

        return ResponseEntity.ok().body(savedArticles);
    }

    // curl -v -X PATCH localhost:8080/articles/6 -H 'Content-Type: application/json' -d '{"title": "Updated article", "body": "Updated article content"}'
    @RequestMapping(method = PATCH, path = "{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article article) {
        if (articlesDao.existsById(id)) {
            article.setId(id);
            Article updatedArticle = articlesDao.save(article);

            return ResponseEntity.ok().body(updatedArticle);
        } else
            return ResponseEntity.notFound().build();
    }

    // curl -v -X DELETE localhost:8080/articles/7
    @RequestMapping(method = DELETE, path = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity deleteArticleById(@PathVariable int id) {
        if (articlesDao.existsById(id)) {
            articlesDao.deleteById(id);

            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
