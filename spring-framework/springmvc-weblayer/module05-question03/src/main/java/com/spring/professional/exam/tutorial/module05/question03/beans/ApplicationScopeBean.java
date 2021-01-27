package com.spring.professional.exam.tutorial.module05.question03.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
@Data
public class ApplicationScopeBean {
    private Integer value;
}
