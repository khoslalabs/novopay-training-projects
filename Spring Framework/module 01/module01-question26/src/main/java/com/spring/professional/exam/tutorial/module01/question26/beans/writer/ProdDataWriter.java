package com.spring.professional.exam.tutorial.module01.question26.beans.writer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class ProdDataWriter implements DataWriter {
}
