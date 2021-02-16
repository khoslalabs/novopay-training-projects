package com.spring.professional.exam.tutorial.module04.question31.storage;

import java.util.Optional;

public interface StorageService {

    int store(String content);

    Optional<String> fetch(int id);
}
