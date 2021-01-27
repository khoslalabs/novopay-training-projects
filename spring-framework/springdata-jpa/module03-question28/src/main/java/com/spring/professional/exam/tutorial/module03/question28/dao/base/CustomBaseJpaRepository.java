package com.spring.professional.exam.tutorial.module03.question28.dao.base;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;

@SuppressWarnings("unused")
public class CustomBaseJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;

    CustomBaseJpaRepository(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        System.out.println("Starting custom implementation of findByFirstNameAndLastName from CustomBaseJpaRepository...");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(employeeRoot.get("lastName"), lastName),
                        criteriaBuilder.equal(employeeRoot.get("firstName"), firstName)
                )
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
