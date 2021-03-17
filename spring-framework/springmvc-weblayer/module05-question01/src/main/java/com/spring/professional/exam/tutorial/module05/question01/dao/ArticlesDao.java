package com.spring.professional.exam.tutorial.module05.question01.dao;

import com.spring.professional.exam.tutorial.module05.question01.ds.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
}
