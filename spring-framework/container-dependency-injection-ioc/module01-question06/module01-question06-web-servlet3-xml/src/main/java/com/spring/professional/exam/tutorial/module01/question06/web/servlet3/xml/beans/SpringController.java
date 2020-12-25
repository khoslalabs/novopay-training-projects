package com.spring.professional.exam.tutorial.module01.question06.web.servlet3.xml.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    private SpringBean1 springBean1;

    public void setSpringBean1(SpringBean1 springBean1) {
        this.springBean1 = springBean1;
    }

    @RequestMapping
    @ResponseBody
    public String index() {
        return springBean1.getHello();
    }
}
