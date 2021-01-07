package com.spring.professional.exam.tutorial.module03.question12.util;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchUtil {
    public static void countDown(CountDownLatch countDownLatch) {
        countDownLatch.countDown();
    }

    @SneakyThrows
    public static void await(CountDownLatch countDownLatch) {
        countDownLatch.await(10, TimeUnit.SECONDS);
    }
}
