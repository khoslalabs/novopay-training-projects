package com.spring.professional.exam.tutorial.module07.question11.dao;

import com.spring.professional.exam.tutorial.module07.question11.ds.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
}
