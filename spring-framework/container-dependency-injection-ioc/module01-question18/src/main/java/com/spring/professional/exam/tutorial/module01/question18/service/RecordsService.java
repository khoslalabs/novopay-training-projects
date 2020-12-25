package com.spring.professional.exam.tutorial.module01.question18.service;

import com.spring.professional.exam.tutorial.module01.question18.bls.RecordsProcessor;
import com.spring.professional.exam.tutorial.module01.question18.reader.RecordsReader;
import com.spring.professional.exam.tutorial.module01.question18.validator.RecordsValidator;
import com.spring.professional.exam.tutorial.module01.question18.validator.RecordsValidatorType;
import com.spring.professional.exam.tutorial.module01.question18.writer.RecordsWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.spring.professional.exam.tutorial.module01.question18.validator.RecordsValidatorType.RecordsValidatorMode.FILE;

@Service
public class RecordsService {
    @Autowired
    @Qualifier("dbRecordsProcessor")
    private RecordsProcessor recordsProcessor;

    @Autowired
    @Qualifier("file-records-reader")
    private RecordsReader recordsReader;

    @Autowired
    @Qualifier("db-writer")
    private RecordsWriter recordsWriter;

    @Autowired
    @RecordsValidatorType(FILE)
    private RecordsValidator recordsValidator;
}
