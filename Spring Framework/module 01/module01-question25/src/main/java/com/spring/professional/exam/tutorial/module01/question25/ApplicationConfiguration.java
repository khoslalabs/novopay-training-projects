package com.spring.professional.exam.tutorial.module01.question25;

import com.spring.professional.exam.tutorial.module01.question25.beans.mappers.DataMapper;
import com.spring.professional.exam.tutorial.module01.question25.beans.processors.DataProcessor;
import com.spring.professional.exam.tutorial.module01.question25.beans.processors.MultiSourceDataProcessor;
import com.spring.professional.exam.tutorial.module01.question25.beans.readers.DataReader;
import com.spring.professional.exam.tutorial.module01.question25.beans.readers.DbDataReader;
import com.spring.professional.exam.tutorial.module01.question25.beans.readers.FileDataReader;
import com.spring.professional.exam.tutorial.module01.question25.beans.writer.DataWriter;
import com.spring.professional.exam.tutorial.module01.question25.beans.writer.DevDataWriter;
import com.spring.professional.exam.tutorial.module01.question25.beans.writer.ProdDataWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DataMapper dataMapper() {
        return new DataMapper();
    }

    @Bean
    @Profile({"database", "file"})
    public DataProcessor multiSourceDataProcessor() {
        return new MultiSourceDataProcessor();
    }

    @Bean
    @Profile("database")
    public DataReader dbDataReader() {
        return new DbDataReader();
    }

    @Bean
    @Profile("file")
    public DataReader fileDataReader() {
        return new FileDataReader();
    }

    @Bean
    @Profile("!prod")
    public DataWriter devDataWriter() {
        return new DevDataWriter();
    }

    @Bean
    @Profile("!dev")
    public DataWriter prodDataWriter() {
        return new ProdDataWriter();
    }
}
