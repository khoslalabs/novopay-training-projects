package com.spring.professional.exam.tutorial.module02.question09;

import com.spring.professional.exam.tutorial.module02.question09.beans.TransactionHistoryServiceClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        TransactionHistoryServiceClient transactionHistoryServiceClient = context.getBean(TransactionHistoryServiceClient.class);

        transactionHistoryServiceClient.saveTransactionData(
                "A001",
                "amount=50",
                "private-key-5232"
        );
    }
}
