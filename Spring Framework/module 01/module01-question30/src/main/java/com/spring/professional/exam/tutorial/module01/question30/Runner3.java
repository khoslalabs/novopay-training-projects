package com.spring.professional.exam.tutorial.module01.question30;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Runner3 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser(
                new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, Runner3.class.getClassLoader())
        );

        System.out.println(parser.parseExpression("'Hello'.concat(' world!')").getValue());
        System.out.println(parser.parseExpression("'2 + 2 equals = '.concat(2 + 2)").getValue());
        System.out.println(parser.parseExpression("new String('Wall Street').toUpperCase()").getValue());
    }
}
