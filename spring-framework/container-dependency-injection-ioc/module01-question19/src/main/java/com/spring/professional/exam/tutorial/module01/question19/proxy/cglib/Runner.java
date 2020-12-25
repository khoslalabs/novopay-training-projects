package com.spring.professional.exam.tutorial.module01.question19.proxy.cglib;

import com.spring.professional.exam.tutorial.module01.question19.dao.DepartmentDao;
import com.spring.professional.exam.tutorial.module01.question19.ds.Department;
import org.springframework.cglib.proxy.Enhancer;

public class Runner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DepartmentDaoMethodInterceptor());
        enhancer.setSuperclass(DepartmentDao.class);
        DepartmentDao departmentDao = (DepartmentDao) enhancer.create();

        Department department = departmentDao.findById(5);
        departmentDao.save(department);
    }
}
