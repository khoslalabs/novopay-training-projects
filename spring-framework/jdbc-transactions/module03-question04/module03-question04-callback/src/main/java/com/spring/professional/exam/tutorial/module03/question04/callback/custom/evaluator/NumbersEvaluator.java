package com.spring.professional.exam.tutorial.module03.question04.callback.custom.evaluator;

import com.spring.professional.exam.tutorial.module03.question04.callback.custom.ds.Pair;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.expression.ExpressionEvaluator;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer.ValuePrinter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersEvaluator {

    public void evaluate(int n, ExpressionEvaluator expressionEvaluator, ValuePrinter valuePrinter) {
        List<Pair> numberPairs = generatePairs(n);

        for (Pair numberPair : numberPairs) {
            valuePrinter.print(
                    expressionEvaluator.evaluate(numberPair.getA(), numberPair.getB())
            );
        }
    }

    private List<Pair> generatePairs(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(i -> new Pair(i, 2 * i))
                .collect(Collectors.toList());
    }
}
