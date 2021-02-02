package com.spring.professional.exam.tutorial.module05.question02.framework.controller;

import com.spring.professional.exam.tutorial.module05.question02.framework.ds.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IController {
    ModelAndView handleRequest(HttpServletRequest req);
}
