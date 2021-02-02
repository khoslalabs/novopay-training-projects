package com.spring.professional.exam.tutorial.module07.question16.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@ResponseStatus(code = NOT_ACCEPTABLE, reason = "Custom Data Rejected")
public class CustomDataRejectedException extends RuntimeException {
}
