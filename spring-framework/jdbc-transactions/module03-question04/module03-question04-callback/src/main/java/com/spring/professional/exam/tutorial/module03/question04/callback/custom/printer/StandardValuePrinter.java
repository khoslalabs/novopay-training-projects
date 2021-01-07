package com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer;

public class StandardValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.println(value);
    }
}
