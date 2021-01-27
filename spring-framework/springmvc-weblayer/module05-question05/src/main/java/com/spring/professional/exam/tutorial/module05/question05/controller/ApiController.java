package com.spring.professional.exam.tutorial.module05.question05.controller;

import com.spring.professional.exam.tutorial.module05.question05.dao.ArticlesDao;
import com.spring.professional.exam.tutorial.module05.question05.ds.Article;
import com.spring.professional.exam.tutorial.module05.question05.ds.ArticleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/articles", produces = APPLICATION_JSON_VALUE)
public class ApiController {

    @Autowired
    private ArticlesDao articlesDao;

    // curl localhost:8080/api/articles |jq
    @GetMapping
    public ResponseEntity<Iterable<Article>> listArticles() {
        return ResponseEntity.ok()
                .body(articlesDao.findAll());
    }

    // curl -I localhost:8080/api/articles
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Iterable<Article>> getArticlesCount() {
        return ResponseEntity.ok()
                .header("Articles-Count", String.valueOf(articlesDao.count()))
                .body(articlesDao.findAll());
    }

    // curl localhost:8080/api/articles/2 |jq
    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        return articlesDao.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());

    }

    // curl -X POST localhost:8080/api/articles/search -H 'Content-Type: application/json' -d '{"bodyLike": "%some%"}' |jq
    @PostMapping(value = "search", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> searchByCriteria(@RequestBody ArticleCriteria articleCriteria) {
        return ResponseEntity.ok()
                .body(articlesDao.findByBodyLikeIgnoreCase(articleCriteria.getBodyLike()));
    }

    // curl -v -X PUT localhost:8080/api/articles -H 'Content-Type: application/json' -d '{"title": "New article", "body": "New article content"}'
    @PutMapping
    public ResponseEntity addArticle(@RequestBody Article article) {
        articlesDao.save(article);

        return ResponseEntity.ok().build();
    }

    // curl -v -X PATCH localhost:8080/api/articles/1 -H 'Content-Type: application/json' -d '{"title": "Updated article", "body": "Updated article content"}'
    @PatchMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateArticle(@PathVariable int id, @RequestBody Article article) {
        if (articlesDao.existsById(id)) {
            article.setId(id);
            articlesDao.save(article);

            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }

    // curl -v -X DELETE localhost:8080/api/articles/3
    @DeleteMapping("{id}")
    public ResponseEntity deleteArticleById(@PathVariable int id) {
        if (articlesDao.existsById(id)) {
            articlesDao.deleteById(id);

            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
