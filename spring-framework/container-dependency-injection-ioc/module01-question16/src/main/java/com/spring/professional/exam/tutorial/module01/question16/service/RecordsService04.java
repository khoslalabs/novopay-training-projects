package com.spring.professional.exam.tutorial.module01.question16.service;

import com.spring.professional.exam.tutorial.module01.question16.non.beans.RecordsValidator;
import com.spring.professional.exam.tutorial.module01.question16.reader.DbRecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordsService04 {

    @Autowired
    public void setRecordsReader(DbRecordsReader recordsReader) {
        System.out.println(
                getClass().getSimpleName() + " setRecordsReader:\n" +
                        "\trecordsReader = " + recordsReader + "\n"
        );
    }

    //@Autowired
    @Autowired(required = false)
    //public void setRecordsReaderAndRecordsValidator(DbRecordsReader recordsReader, Optional<RecordsValidator> recordsValidator) {
    //public void setRecordsReaderAndRecordsValidator(DbRecordsReader recordsReader, @Nullable RecordsValidator recordsValidator) {
    //public void setRecordsReaderAndRecordsValidator(DbRecordsReader recordsReader, @Autowired(required = false) RecordsValidator recordsValidator) {
    public void setRecordsReaderAndRecordsValidator(DbRecordsReader recordsReader, RecordsValidator recordsValidator) {
        System.out.println(
                getClass().getSimpleName() + " setRecordsReaderAndRecordsValidator:\n" +
                        "\trecordsReader = " + recordsReader + "\n" +
                        "\trecordsValidator = " + recordsValidator + "\n"
        );
    }
}
