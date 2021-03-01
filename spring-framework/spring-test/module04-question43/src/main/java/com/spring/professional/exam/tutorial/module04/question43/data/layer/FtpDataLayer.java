package com.spring.professional.exam.tutorial.module04.question43.data.layer;

import com.spring.professional.exam.tutorial.module04.question43.ds.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FtpDataLayer {
    public List<Person> getData() {
        System.out.println("Fetching data from ftp...");

        return Arrays.asList(
                new Person(1, "John"),
                new Person(2, "Dave"),
                new Person(3, "Peter")
        );
    }
}
