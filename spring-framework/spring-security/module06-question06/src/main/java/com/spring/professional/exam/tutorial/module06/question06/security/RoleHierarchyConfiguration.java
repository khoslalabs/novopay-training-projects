package com.spring.professional.exam.tutorial.module06.question06.security;

import com.spring.professional.exam.tutorial.module06.question06.security.utils.RolesHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(
                new RolesHierarchyBuilder()
                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.CUSTOMERS_ADMIN)
                        .append(SecurityRoles.CUSTOMERS_ADMIN, SecurityRoles.CUSTOMERS_PAG_VIEW)
                        .append(SecurityRoles.CUSTOMERS_ADMIN, SecurityRoles.CUSTOMER_VIEW)
                        .append(SecurityRoles.CUSTOMERS_ADMIN, SecurityRoles.CUSTOMER_CREATE)
                        .append(SecurityRoles.CUSTOMERS_ADMIN, SecurityRoles.CUSTOMER_DELETE)

                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.DEPARTMENTS_ADMIN)
                        .append(SecurityRoles.DEPARTMENTS_ADMIN, SecurityRoles.DEPARTMENTS_PAG_VIEW)
                        .append(SecurityRoles.DEPARTMENTS_ADMIN, SecurityRoles.DEPARTMENT_VIEW)
                        .append(SecurityRoles.DEPARTMENTS_ADMIN, SecurityRoles.DEPARTMENT_CREATE)
                        .append(SecurityRoles.DEPARTMENTS_ADMIN, SecurityRoles.DEPARTMENT_DELETE)

                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.EMPLOYEES_ADMIN)
                        .append(SecurityRoles.EMPLOYEES_ADMIN, SecurityRoles.EMPLOYEES_PAG_VIEW)
                        .append(SecurityRoles.EMPLOYEES_ADMIN, SecurityRoles.EMPLOYEE_VIEW)
                        .append(SecurityRoles.EMPLOYEES_ADMIN, SecurityRoles.EMPLOYEE_CREATE)
                        .append(SecurityRoles.EMPLOYEES_ADMIN, SecurityRoles.EMPLOYEE_DELETE)

                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.ALL_VIEWS)
                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.ALL_CREATES)
                        .append(SecurityRoles.SUPER_ADMIN, SecurityRoles.ALL_DELETES)

                        .append(SecurityRoles.ALL_VIEWS, SecurityRoles.CUSTOMER_VIEW)
                        .append(SecurityRoles.ALL_VIEWS, SecurityRoles.DEPARTMENT_VIEW)
                        .append(SecurityRoles.ALL_VIEWS, SecurityRoles.EMPLOYEE_VIEW)

                        .append(SecurityRoles.ALL_CREATES, SecurityRoles.CUSTOMER_CREATE)
                        .append(SecurityRoles.ALL_CREATES, SecurityRoles.DEPARTMENT_CREATE)
                        .append(SecurityRoles.ALL_CREATES, SecurityRoles.EMPLOYEE_CREATE)

                        .append(SecurityRoles.ALL_DELETES, SecurityRoles.CUSTOMER_DELETE)
                        .append(SecurityRoles.ALL_DELETES, SecurityRoles.DEPARTMENT_DELETE)
                        .append(SecurityRoles.ALL_DELETES, SecurityRoles.EMPLOYEE_DELETE)

                        .build()
        );

        return roleHierarchy;
    }
}
