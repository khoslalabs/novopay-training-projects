package com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer;

public class DecoratedValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.println(String.format("Value = [%d]", value));
    }
}
