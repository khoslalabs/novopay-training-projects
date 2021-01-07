package com.spring.professional.exam.tutorial.module03.question12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.spring.professional.exam.tutorial.module03.question12.util.CountDownLatchUtil.await;
import static com.spring.professional.exam.tutorial.module03.question12.util.CountDownLatchUtil.countDown;

@Component
public class TransactionIsolationExampleInvoker {
    @Autowired
    private TransactionIsolationExample transactionIsolationExample;

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void execute() {
        System.out.println("Starting Repeatable Read Example");

        executorService.execute(() -> {
            transactionIsolationExample.readOperations();
            transactionIsolationExample.nextReadOperation();

            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        executorService.execute(() -> {
            transactionIsolationExample.writeOperations();
            countDown(transactionIsolationExample.getWriteDoneAndCommittedLatch());

            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        await(transactionIsolationExample.getReadWriteLatch());

        executorService.shutdown();

        System.out.println("Finishing Repeatable Read Example");
    }
}
