package com.spring.professional.exam.tutorial.module05.question02.application.view;

import com.spring.professional.exam.tutorial.module05.question02.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return "Hello from Index Controller and View<br/>" +
                "Please visit one of following sites:<br/>" +
                "<ul>" +
                "<li><a href='/add-numbers?numberA=2&numberB=4'>/add-numbers?numberA=2&numberB=4</a></li>" +
                "<li><a href='/square-number?number=4'>/square-number?number=4</a></li>" +
                "</ul>";
    }
}
