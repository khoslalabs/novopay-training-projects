package com.spring.professional.exam.tutorial.module01.question18.bls;

import com.spring.professional.exam.tutorial.module01.question18.ds.Record;

import java.util.Collection;

public interface RecordsProcessor {
    Collection<Record> processRecords(Collection<Record> records);
}
