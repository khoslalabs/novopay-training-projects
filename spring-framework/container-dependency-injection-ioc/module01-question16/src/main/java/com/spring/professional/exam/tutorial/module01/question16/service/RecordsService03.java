package com.spring.professional.exam.tutorial.module01.question16.service;

import com.spring.professional.exam.tutorial.module01.question16.bls.DbRecordsProcessor;
import com.spring.professional.exam.tutorial.module01.question16.non.beans.RecordsHash;
import com.spring.professional.exam.tutorial.module01.question16.non.beans.RecordsUtil;
import com.spring.professional.exam.tutorial.module01.question16.non.beans.RecordsValidator;
import com.spring.professional.exam.tutorial.module01.question16.reader.DbRecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordsService03 {

    @Autowired
    private RecordsService03(DbRecordsReader recordsReader, DbRecordsProcessor recordsProcessor, Optional<RecordsUtil> recordsUtil, @Nullable RecordsHash recordsHash, @Autowired(required = false) RecordsValidator recordsValidator) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsUtil = " + recordsUtil + "\n" +
                        getClass().getSimpleName() + " recordsHash = " + recordsHash + "\n" +
                        getClass().getSimpleName() + " recordsValidator = " + recordsValidator + "\n"
        );
    }

    //@Autowired
    RecordsService03(DbRecordsReader recordsReader, DbRecordsProcessor recordsProcessor) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n"
        );
    }
}
