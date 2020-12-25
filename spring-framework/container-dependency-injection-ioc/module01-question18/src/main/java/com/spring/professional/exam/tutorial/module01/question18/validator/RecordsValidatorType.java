package com.spring.professional.exam.tutorial.module01.question18.validator;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RecordsValidatorType {

    RecordsValidatorMode value();

    enum RecordsValidatorMode {
        DB,
        FILE
    }
}
