package com.spring.professional.exam.tutorial.module04.question31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This example implements simple 'mock' for db and file storage that uses custom metrics.
 * Metrics are implemented with Micrometer used by Spring Boot Actuator and exposed via /actuator/metrics
 *
 * You can use curl to persist data:
 * curl -i -X PUT -H 'Content-Type: text/string' -d 'John' localhost:8080/db/storage
 * curl -i -X PUT -H 'Content-Type: text/string' -d 'Tom' localhost:8080/db/storage
 * curl -i -X PUT -H 'Content-Type: text/string' -d 'Dan' localhost:8080/db/storage
 *
 * curl -i -X PUT -H 'Content-Type: text/string' -d 'Mary' localhost:8080/file/storage
 * curl -i -X PUT -H 'Content-Type: text/string' -d 'Jane' localhost:8080/file/storage
 *
 * Then you can fetch data:
 * curl -i -X GET localhost:8080/db/storage/1
 * curl -i -X GET localhost:8080/db/storage/2
 * curl -i -X GET localhost:8080/db/storage/3
 *
 * curl -i -X GET localhost:8080/file/storage/1
 * curl -i -X GET localhost:8080/file/storage/2
 *
 * Metrics are available at following endpoints:
 * curl -i -X GET localhost:8080/actuator/metrics/storage.object.count
 * curl -i -X GET localhost:8080/actuator/metrics/storage.db.object.avg.size
 * curl -i -X GET localhost:8080/actuator/metrics/storage.file.object.avg.size
 *
 */
@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
}
