package com.spring.professional.exam.tutorial.module01.question24.profiles.activation.programmatically.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileStoreFinancialDataDao implements FinancialDataDao {
}
