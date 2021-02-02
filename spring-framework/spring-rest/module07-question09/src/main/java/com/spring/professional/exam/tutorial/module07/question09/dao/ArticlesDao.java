package com.spring.professional.exam.tutorial.module07.question09.dao;

import com.spring.professional.exam.tutorial.module07.question09.ds.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
    List<Article> findByBodyLikeIgnoreCase(String content);
}
