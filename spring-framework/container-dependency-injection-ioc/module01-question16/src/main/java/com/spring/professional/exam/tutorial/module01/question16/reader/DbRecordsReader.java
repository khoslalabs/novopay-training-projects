package com.spring.professional.exam.tutorial.module01.question16.reader;

import com.spring.professional.exam.tutorial.module01.question16.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return Collections.emptyList();
    }
}
