package com.spring.professional.exam.tutorial.module01.question06.web.servlet2.beans;

public class SpringBean1 {
    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    public String getHello() {
        return "Hello from Spring Bean 1";
    }

    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean2");
        this.springBean2 = springBean2;
    }

    public void setSpringBean3(SpringBean3 springBean3) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean3");
        this.springBean3 = springBean3;
    }
}
