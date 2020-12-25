package com.spring.professional.exam.tutorial.module01.question16.backup;

import com.spring.professional.exam.tutorial.module01.question16.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbRecordsBackup implements RecordsBackup {
    @Override
    public void backupRecords(Collection<Record> records) {

    }
}
