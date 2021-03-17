package com.spring.professional.exam.tutorial.module05.question02.application.controller;

import com.spring.professional.exam.tutorial.module05.question02.application.view.IndexView;
import com.spring.professional.exam.tutorial.module05.question02.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/")
public class IndexController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {
        return new ModelAndView(
                new SimpleModel(),
                new IndexView()
        );
    }
}
