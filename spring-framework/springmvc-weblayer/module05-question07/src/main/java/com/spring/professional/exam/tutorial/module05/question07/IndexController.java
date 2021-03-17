package com.spring.professional.exam.tutorial.module05.question07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    // curl localhost:8080/actionA?name=John
    // curl localhost:8080/actionA
    @GetMapping("/actionA")
    @ResponseBody
    public String actionA(@RequestParam("name") String name) {
        return String.format("Retrieved name = [%s]\n", name);
    }

    // curl "localhost:8080/actionB?name=John&city=NYC"
    // curl localhost:8080/actionB?name=John
    @GetMapping("/actionB")
    @ResponseBody
    public String actionB(@RequestParam("name") String name, @RequestParam(value = "city", required = false) String city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city);
    }

    // curl "localhost:8080/actionC?name=John&city=NYC"
    // curl localhost:8080/actionC?name=John
    @GetMapping("/actionC")
    @ResponseBody
    public String actionC(@RequestParam("name") String name, @RequestParam(value = "city", required = false, defaultValue = "N/A") String city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city);
    }

    // curl "localhost:8080/actionD?name=John&city=NYC"
    // curl localhost:8080/actionD?name=John
    @GetMapping("/actionD")
    @ResponseBody
    public String actionD(@RequestParam("name") String name, @RequestParam(value = "city") Optional<String> city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", name, city.orElse("N/A"));
    }

    // curl "localhost:8080/actionE?name=John&city=NYC&country=US"
    @GetMapping("/actionE")
    @ResponseBody
    public String actionE(@RequestParam Map<String, String> parameters) {
        String parametersAsString = parameters.entrySet().stream()
                .map(entry -> String.format("[%s] -> [%s]", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));

        return String.format("Retrieved parameters map = [%s]\n", parametersAsString);
    }

    // curl "localhost:8080/actionF?cities=1,2,3"
    @GetMapping("/actionF")
    @ResponseBody
    public String actionF(@RequestParam("cities") List<String> cities) {
        return String.format("Retrieved cities identifiers = [%s]\n", String.join(", ", cities));
    }

    // curl "localhost:8080/actionG?name=John&city=NYC&country=US"
    @GetMapping("/actionG")
    @ResponseBody
    public String actionG(@RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("country") String country) {
        return String.format("Retrieved name = [%s], city = [%s], country = [%s]\n", name, city, country);
    }
}
