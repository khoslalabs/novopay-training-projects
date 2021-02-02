package com.spring.professional.exam.tutorial.module05.question02.application.controller;

import com.spring.professional.exam.tutorial.module05.question02.application.view.SquareNumberView;
import com.spring.professional.exam.tutorial.module05.question02.framework.controller.ControllerMapping;
import com.spring.professional.exam.tutorial.module05.question02.framework.controller.IController;
import com.spring.professional.exam.tutorial.module05.question02.framework.ds.ModelAndView;
import com.spring.professional.exam.tutorial.module05.question02.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

import static java.lang.String.valueOf;

@ControllerMapping("/square-number")
public class SquareNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {
        Model model = new SimpleModel();

        int number = Integer.parseInt(req.getParameter("number"));
        int numberSquare = (int) Math.pow(number, 2);

        model.set("number", valueOf(number));
        model.set("numberSquare", valueOf(numberSquare));

        return new ModelAndView(
                model,
                new SquareNumberView()
        );
    }
}
