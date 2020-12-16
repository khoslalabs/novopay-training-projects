package com.spring.professional.exam.tutorial.module01.question18.writer;

import com.spring.professional.exam.tutorial.module01.question18.ds.Record;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("db-writer")
public class DbRecordsWriter implements RecordsWriter {
    @Override
    public void writeRecords(Collection<Record> records) {

    }
}
