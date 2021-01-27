package com.spring.professional.exam.tutorial.module05.question02.framework.ds;

import com.spring.professional.exam.tutorial.module05.question02.framework.model.Model;
import com.spring.professional.exam.tutorial.module05.question02.framework.view.View;

public class ModelAndView {
    private Model model;
    private View view;

    public ModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
