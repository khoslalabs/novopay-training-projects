package com.spring.professional.exam.tutorial.module07.question16.advice;

import com.spring.professional.exam.tutorial.module07.question16.exception.CustomDataRejectedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(CustomDataRejectedException.class)
    @ResponseBody
    public String customDataRejectedExceptionHandler() {
        return "Exception was handled by global handler";
    }
}
