package com.spring.professional.exam.tutorial.module01.question18.reader;

import com.spring.professional.exam.tutorial.module01.question18.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("file-records-reader")
public class FileRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
