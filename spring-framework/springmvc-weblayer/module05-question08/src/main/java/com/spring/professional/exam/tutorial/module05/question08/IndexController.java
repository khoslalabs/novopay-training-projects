package com.spring.professional.exam.tutorial.module05.question08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    // curl localhost:8080/actionA/cities/ORD
    // curl localhost:8080/actionA/cities/LAX
    @GetMapping("/actionA/cities/{city}")
    @ResponseBody
    public String cityByCode(@PathVariable("city") String city) {
        return String.format("Retrieved city = [%s]\n", city);
    }

    // curl localhost:8080/actionB/countries/US/cities/DEN
    // curl localhost:8080/actionB/countries/PL/cities/KRK
    @GetMapping("/actionB/countries/{country}/cities/{city}")
    @ResponseBody
    public String countryAndCityByCode(@PathVariable("country") String country, @PathVariable(value = "city") String city) {
        return String.format("Retrieved country = [%s], city = [%s]\n", country, city);
    }

    // curl localhost:8080/actionC/countries/US/cities/DEN
    // curl localhost:8080/actionC/countries/US
    @GetMapping({"/actionC/countries/{country}/cities/{city}", "/actionC/countries/{country}"})
    @ResponseBody
    public String countryAndOptionalCityByCode(@PathVariable("country") String country, @PathVariable(value = "city", required = false) String city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", country, city);
    }

    // curl localhost:8080/actionD/countries/US/cities/DEN
    // curl localhost:8080/actionD/countries/US
    @GetMapping({"/actionD/countries/{country}/cities/{city}", "/actionD/countries/{country}"})
    @ResponseBody
    public String countryAndOptionalCityByCodeJava8(@PathVariable("country") String country, @PathVariable(value = "city") Optional<String> city) {
        return String.format("Retrieved name = [%s], city = [%s]\n", country, city.orElse("N/A"));
    }

    // curl localhost:8080/actionE/countries/US/cities/DFW/zip/75038
    @GetMapping("/actionE/countries/{country}/cities/{city}/zip/{code}")
    @ResponseBody
    public String actionE(@PathVariable Map<String, String> parameters) {
        String parametersAsString = parameters.entrySet().stream()
                .map(entry -> String.format("[%s] -> [%s]", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));

        return String.format("Retrieved parameters map = [%s]\n", parametersAsString);
    }

    // curl localhost:8080/actionF/countries/US,PL,UK
    @GetMapping("/actionF/countries/{countries}")
    @ResponseBody
    public String actionF(@PathVariable("countries") List<String> countries) {
        return String.format("Retrieved cities identifiers = [%s]\n", String.join(", ", countries));
    }
}
