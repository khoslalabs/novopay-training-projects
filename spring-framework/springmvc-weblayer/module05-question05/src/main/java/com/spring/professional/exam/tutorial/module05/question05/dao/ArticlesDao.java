package com.spring.professional.exam.tutorial.module05.question05.dao;

import com.spring.professional.exam.tutorial.module05.question05.ds.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
    List<Article> findByBodyLikeIgnoreCase(String content);
}
