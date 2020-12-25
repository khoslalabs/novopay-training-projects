package com.spring.professional.exam.tutorial.module01.question18.writer;

import com.spring.professional.exam.tutorial.module01.question18.ds.Record;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("file-writer")
public class FileRecordsWriter implements RecordsWriter {
    @Override
    public void writeRecords(Collection<Record> records) {

    }
}
