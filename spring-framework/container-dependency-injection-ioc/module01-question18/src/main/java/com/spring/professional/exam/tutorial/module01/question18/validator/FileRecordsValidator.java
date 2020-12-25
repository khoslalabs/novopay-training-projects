package com.spring.professional.exam.tutorial.module01.question18.validator;

import com.spring.professional.exam.tutorial.module01.question18.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.spring.professional.exam.tutorial.module01.question18.validator.RecordsValidatorType.RecordsValidatorMode.FILE;

@Component
@RecordsValidatorType(FILE)
public class FileRecordsValidator implements RecordsValidator {
    @Override
    public void validate(Collection<Record> records) {

    }
}
