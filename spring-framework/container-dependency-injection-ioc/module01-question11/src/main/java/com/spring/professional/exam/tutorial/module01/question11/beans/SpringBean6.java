package com.spring.professional.exam.tutorial.module01.question11.beans;

//@Component
//@Scope("prototype")
public class SpringBean6 {
    public SpringBean6() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Prototype Bean that is referenced from Singleton Bean SpringBean5");
    }
}
