package com.spring.professional.exam.tutorial.module07.question14.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(code = BAD_REQUEST, reason = "Custom Bad Request")
public class CustomBadRequestException extends RuntimeException {
}
