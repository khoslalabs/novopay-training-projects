package com.spring.professional.exam.tutorial.module06.question04.security.filter;

import com.spring.professional.exam.tutorial.module06.question04.security.SecurityRoles;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Collections;

// will authenticate based on request parameter
// http://localhost:8080/employees?X-AUTH-TOKEN=SECRET_AUTH_TOKEN_ADMIN
public class CustomRequestParameterAuthenticationFilter extends GenericFilterBean {

    public static final String SECRET_AUTH_TOKEN_ADMIN = "SECRET_AUTH_TOKEN_ADMIN";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (SECRET_AUTH_TOKEN_ADMIN.equals(request.getParameter("X-AUTH-TOKEN")) && securityContext != null) {
            securityContext.setAuthentication(
                    new AnonymousAuthenticationToken(
                            "x-auth", "X-ADMIN",
                            Collections.singletonList(
                                    new SimpleGrantedAuthority(SecurityRoles.ROLE_PREFIX + SecurityRoles.SUPER_ADMIN)
                            )
                    )
            );
        }

        chain.doFilter(request, response);
    }
}
