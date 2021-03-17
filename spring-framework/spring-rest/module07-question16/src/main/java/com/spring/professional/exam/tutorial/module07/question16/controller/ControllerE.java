package com.spring.professional.exam.tutorial.module07.question16.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("controllerE")
public class ControllerE {

    // Example usage of:
    // - @RequestParam
    // - @PathVariable
    // - @MatrixVariable
    // - @CookieValue
    // - @RequestHeader

    // curl "http://localhost:8080/controllerE/methodA?firstName=John&lastName=Doe"
    @GetMapping("/methodA")
    public String methodA(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName);
    }

    // curl http://localhost:8080/controllerE/methodB/firstName/John/lastName/Doe
    @GetMapping("/methodB/firstName/{firstName}/lastName/{lastName}")
    public String methodB(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return String.format("Received firstName = [%s], lastName = [%s]\n", firstName, lastName);
    }

    // curl "http://localhost:8080/controllerE/methodC/employees/id=1;name=John"
    @GetMapping("/methodC/employees/{employee}")
    public String methodC(@MatrixVariable(pathVar = "employee", name = "id") int id, @MatrixVariable(pathVar = "employee", name = "name") String name) {
        return String.format("Received request id = [%d], name = [%s]\n", id, name);
    }

    // curl -c cookie.txt -b cookie.txt http://localhost:8080/controllerE/methodD/set-cookie
    @GetMapping("/methodD/set-cookie")
    public String methodDSetCookie(HttpServletResponse servletResponse) {
        servletResponse.addCookie(new Cookie("user-id", "15"));

        return "Cookie set successfully\n";
    }

    // curl -c cookie.txt -b cookie.txt http://localhost:8080/controllerE/methodD/read-cookie
    @GetMapping("/methodD/read-cookie")
    public String methodDReadCookie(@CookieValue("user-id") String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    // curl -H "Accept-Version: v2.1" http://localhost:8080/controllerE/methodE
    @GetMapping("/methodE")
    public String methodE(@RequestHeader("Accept-Version") String acceptVersion) {
        return String.format("Received request with Accept-Version = [%s]\n", acceptVersion);
    }
}
