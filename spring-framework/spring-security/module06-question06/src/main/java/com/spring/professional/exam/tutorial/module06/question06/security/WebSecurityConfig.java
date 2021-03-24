package com.spring.professional.exam.tutorial.module06.question06.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import static com.spring.professional.exam.tutorial.module06.question06.security.SecurityRoles.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .expressionHandler(expressionHandler())
                .mvcMatchers("/", "/home").permitAll()

                .mvcMatchers("/employees").hasRole(EMPLOYEES_PAG_VIEW)
                .mvcMatchers("/employees/view/**").hasRole(EMPLOYEE_VIEW)
                .mvcMatchers("/employees/create").hasRole(EMPLOYEE_CREATE)
                .mvcMatchers("/employees/delete/*").hasRole(EMPLOYEE_DELETE)

                .mvcMatchers("/departments").hasRole(DEPARTMENTS_PAG_VIEW)
                .mvcMatchers("/departments/view/*").hasRole(DEPARTMENT_VIEW)
                .mvcMatchers("/departments/create").hasRole(DEPARTMENT_CREATE)
                .mvcMatchers("/departments/**/delete/**").hasRole(DEPARTMENT_DELETE)

                .mvcMatchers("/c??to?er?").hasRole(CUSTOMERS_PAG_VIEW)
                .mvcMatchers("/customers/view/*").hasRole(CUSTOMER_VIEW)
                .mvcMatchers("/customers/create").hasRole(CUSTOMER_CREATE)
                .mvcMatchers("/customers/delete/*").hasRole(CUSTOMER_DELETE)

                .mvcMatchers("/**/view/**").hasRole(ALL_VIEWS)
                .mvcMatchers("/**/create/**").hasRole(ALL_CREATES)
                .mvcMatchers("/**/delete/**").hasRole(ALL_DELETES)

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(encoder.encode("john"))
                .roles(SUPER_ADMIN)
                .and()
                .withUser("emma")
                .password(encoder.encode("emma"))
                .roles(EMPLOYEES_ADMIN)
                .and()
                .withUser("william")
                .password(encoder.encode("william"))
                .roles(DEPARTMENTS_ADMIN)
                .and()
                .withUser("lucas")
                .password(encoder.encode("lucas"))
                .roles(CUSTOMERS_ADMIN)
                .and()
                .withUser("tom")
                .password(encoder.encode("tom"))
                .roles()
                .and()
                .withUser("charles")
                .password(encoder.encode("charles"))
                .roles(ALL_VIEWS)
                .and()
                .withUser("joe")
                .password(encoder.encode("joe"))
                .roles(ALL_CREATES)
                .and()
                .withUser("shawn")
                .password(encoder.encode("shawn"))
                .roles(ALL_DELETES);

    }

    private DefaultWebSecurityExpressionHandler expressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }
}
