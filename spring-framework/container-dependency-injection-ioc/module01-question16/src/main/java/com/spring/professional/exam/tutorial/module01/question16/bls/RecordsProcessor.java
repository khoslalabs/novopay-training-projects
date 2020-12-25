package com.spring.professional.exam.tutorial.module01.question16.bls;

import com.spring.professional.exam.tutorial.module01.question16.ds.Record;

import java.util.Collection;

public interface RecordsProcessor {
    Collection<Record> processRecords(Collection<Record> records);
}
