package com.spring.professional.exam.tutorial.module04.question39.controller;

import com.spring.professional.exam.tutorial.module04.question39.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question39.ds.Cities;
import com.spring.professional.exam.tutorial.module04.question39.ds.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityDao cityDao;

    @GetMapping("/cities")
    public Cities getCities() {
        return new Cities(cityDao.findAll());
    }

    @PutMapping("/cities")
    public void putCity(@RequestBody City city) {
        cityDao.save(city);
    }
}
