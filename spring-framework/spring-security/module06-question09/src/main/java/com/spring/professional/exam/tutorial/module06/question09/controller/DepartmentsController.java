package com.spring.professional.exam.tutorial.module06.question09.controller;

import com.spring.professional.exam.tutorial.module06.question09.dao.DepartmentsDao;
import com.spring.professional.exam.tutorial.module06.question09.ds.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import static com.spring.professional.exam.tutorial.module06.question09.security.SecurityRoles.*;

@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentsDao departmentsDao;

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_READ)
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentsDao.findAll());
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_CREATE)
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentsDao.save(department);

            return "redirect:/departments";
        }
    }

    @RolesAllowed(ROLE_PREFIX + DEPARTMENTS_DELETE)
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);

        return "redirect:/departments";
    }
}
