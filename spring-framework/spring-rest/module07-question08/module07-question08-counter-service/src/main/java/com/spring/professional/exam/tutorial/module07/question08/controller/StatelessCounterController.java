package com.spring.professional.exam.tutorial.module07.question08.controller;

import com.spring.professional.exam.tutorial.module07.question08.ds.CounterServiceRequest;
import com.spring.professional.exam.tutorial.module07.question08.ds.CounterServiceResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateless")
public class StatelessCounterController {

    @PostMapping("/countUp")
    public CounterServiceResponse countUp(@RequestBody CounterServiceRequest counterServiceRequest) {
        return new CounterServiceResponse(
                counterServiceRequest.getNumber() + 1
        );
    }
}
