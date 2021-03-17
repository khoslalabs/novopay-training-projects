package com.spring.professional.exam.tutorial.module07.question10.controller;

import com.spring.professional.exam.tutorial.module07.question10.dao.ArticlesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticlesController {

    @Autowired
    private ArticlesDao articlesDao;

    // http://localhost:8080/articles
    @GetMapping("/articles")
    public String listArticles(Model model) {
        model.addAttribute("articles", articlesDao.findAll());

        return "index";
    }
}
