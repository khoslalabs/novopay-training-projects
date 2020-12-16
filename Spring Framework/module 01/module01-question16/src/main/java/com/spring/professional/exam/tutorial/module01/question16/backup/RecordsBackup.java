package com.spring.professional.exam.tutorial.module01.question16.backup;

import com.spring.professional.exam.tutorial.module01.question16.ds.Record;

import java.util.Collection;

public interface RecordsBackup {
    void backupRecords(Collection<Record> records);
}
