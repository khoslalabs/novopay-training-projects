package com.spring.professional.exam.tutorial.module01.question10.scopes.web.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean2 {
}
