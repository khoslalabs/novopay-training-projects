package com.spring.professional.exam.tutorial.module01.question16.service;

import com.spring.professional.exam.tutorial.module01.question16.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService05 {

    @Autowired
    public void setRecordsReaders(List<RecordsReader> recordsReaders) {
        System.out.println(getClass().getSimpleName() + " setRecordsReaders:");
        recordsReaders.stream()
                .map(r -> "\t" + r.getClass().getSimpleName())
                .forEach(System.out::println);
    }
}
