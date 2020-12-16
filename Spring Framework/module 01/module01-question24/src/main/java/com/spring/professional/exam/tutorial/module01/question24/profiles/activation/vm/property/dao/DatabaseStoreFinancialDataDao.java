package com.spring.professional.exam.tutorial.module01.question24.profiles.activation.vm.property.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
}
