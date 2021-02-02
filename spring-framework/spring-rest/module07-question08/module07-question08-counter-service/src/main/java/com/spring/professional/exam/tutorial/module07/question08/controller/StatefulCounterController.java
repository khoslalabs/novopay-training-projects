package com.spring.professional.exam.tutorial.module07.question08.controller;

import com.spring.professional.exam.tutorial.module07.question08.ds.CounterServiceResponse;
import com.spring.professional.exam.tutorial.module07.question08.service.MutableCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateful")
public class StatefulCounterController {

    @Autowired
    private MutableCounter mutableCounter;

    @PostMapping("/countUp")
    public CounterServiceResponse countUp() {
        mutableCounter.countUp();

        return new CounterServiceResponse(
                mutableCounter.getNumber()
        );
    }
}
