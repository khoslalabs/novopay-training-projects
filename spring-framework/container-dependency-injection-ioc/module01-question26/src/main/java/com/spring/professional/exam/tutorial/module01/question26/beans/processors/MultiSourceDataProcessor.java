package com.spring.professional.exam.tutorial.module01.question26.beans.processors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"database", "file"})
public class MultiSourceDataProcessor implements DataProcessor {
}
