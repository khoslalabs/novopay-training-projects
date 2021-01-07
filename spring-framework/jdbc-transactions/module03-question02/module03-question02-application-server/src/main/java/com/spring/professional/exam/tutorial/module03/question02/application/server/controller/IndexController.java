package com.spring.professional.exam.tutorial.module03.question02.application.server.controller;

import com.spring.professional.exam.tutorial.module03.question02.application.server.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping
    @ResponseBody
    public String index() {
        return String.join(", ", employeeDao.findEmployeeEmails());
    }
}
