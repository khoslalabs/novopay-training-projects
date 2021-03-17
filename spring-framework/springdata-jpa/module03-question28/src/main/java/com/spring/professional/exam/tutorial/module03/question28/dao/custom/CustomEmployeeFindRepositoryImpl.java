package com.spring.professional.exam.tutorial.module03.question28.dao.custom;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomEmployeeFindRepositoryImpl implements CustomEmployeeFindRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        System.out.println("Starting custom implementation of findByFirstNameAndLastName from CustomEmployeeFindRepositoryImpl...");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(employeeRoot.get("firstName"), firstName),
                        criteriaBuilder.equal(employeeRoot.get("lastName"), lastName)
                )
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
