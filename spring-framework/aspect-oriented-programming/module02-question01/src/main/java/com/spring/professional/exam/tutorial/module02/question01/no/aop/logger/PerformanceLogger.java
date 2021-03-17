package com.spring.professional.exam.tutorial.module02.question01.no.aop.logger;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.logging.Logger;

@Component
public class PerformanceLogger {

    private Logger logger = Logger.getLogger("performance.logger");

    public PerformanceLoggerInfo start(String name) {
        return new PerformanceLoggerInfo(name, System.currentTimeMillis());
    }

    public void stop(PerformanceLoggerInfo performanceLoggerInfo) {
        long startTime = performanceLoggerInfo.getStartTime();
        long finishTime = System.currentTimeMillis();
        logger.info(String.format("Duration of %s execution was %s", performanceLoggerInfo.getName(), Duration.ofMillis(finishTime - startTime)));
    }

    public static class PerformanceLoggerInfo {

        private final String name;
        private final long startTime;

        PerformanceLoggerInfo(String name, long startTime) {

            this.name = name;
            this.startTime = startTime;
        }

        String getName() {
            return name;
        }

        long getStartTime() {
            return startTime;
        }
    }
}
