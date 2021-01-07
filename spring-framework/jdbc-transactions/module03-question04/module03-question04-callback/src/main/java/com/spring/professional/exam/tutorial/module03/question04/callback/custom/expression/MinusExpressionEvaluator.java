package com.spring.professional.exam.tutorial.module03.question04.callback.custom.expression;

public class MinusExpressionEvaluator implements ExpressionEvaluator {
    @Override
    public int evaluate(int a, int b) {
        return a - b;
    }
}
