package com.spring.professional.exam.tutorial.module03.question12.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static com.spring.professional.exam.tutorial.module03.question12.util.CountDownLatchUtil.await;
import static com.spring.professional.exam.tutorial.module03.question12.util.CountDownLatchUtil.countDown;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
//@Transactional(isolation = Isolation.REPEATABLE_READ)
//@Transactional(isolation = Isolation.READ_COMMITTED)
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class TransactionIsolationExample extends AbstractIsolationExample {
    public void readOperations() {
        System.out.println("Starting Reading Thread");

        System.out.println("First Read Operation - second transaction did not save data yet");
        readOperation();
        countDown(fistReadOnUnsavedAndNotCommittedLatch);

        await(writeDoneNotCommittedLatch);
        System.out.println("Second Read Operation - second transaction did save data, but did not commit");
        readOperation();
        countDown(secondReadOnSavedButNotCommittedLatch);

        await(writeDoneAndCommittedLatch);
        System.out.println("Third Read Operation - second transaction did save and commit data");
        readOperation();

        System.out.println("Finishing Reading Thread");
    }

    public void nextReadOperation() {
        System.out.println("Fourth Read Operation - second transaction did save and commit data, new read transaction created");
        readOperation();
    }

    public void writeOperations() {
        System.out.println("Starting Writing Thread");

        await(fistReadOnUnsavedAndNotCommittedLatch);
        System.out.println("Write Operation");
        writeOperation();
        countDown(writeDoneNotCommittedLatch);

        await(secondReadOnSavedButNotCommittedLatch);

        System.out.println("Finishing Writing Thread, Write Transaction will be committed");
    }
}
