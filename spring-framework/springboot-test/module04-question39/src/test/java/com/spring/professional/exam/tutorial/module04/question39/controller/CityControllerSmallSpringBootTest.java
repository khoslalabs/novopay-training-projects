package com.spring.professional.exam.tutorial.module04.question39.controller;

import com.spring.professional.exam.tutorial.module04.question39.dao.CityDao;
import com.spring.professional.exam.tutorial.module04.question39.ds.Cities;
import com.spring.professional.exam.tutorial.module04.question39.ds.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CityController.class)
public class CityControllerSmallSpringBootTest {

    @Autowired
    private CityController cityController;
    @MockBean
    private CityDao cityDao;

    @Test
    public void shouldSaveFewCities() {
        cityController.putCity(City.builder().name("Los Angeles").build());
        cityController.putCity(City.builder().name("New York").build());
        cityController.putCity(City.builder().name("San Francisco").build());

        verify(cityDao).save(new City(null, "Los Angeles"));
        verify(cityDao).save(new City(null, "New York"));
        verify(cityDao).save(new City(null, "San Francisco"));
    }

    @Test
    public void shouldFetchCities() {
        when(cityDao.findAll())
                .thenReturn(Arrays.asList(
                        new City(1, "Los Angeles"),
                        new City(2, "New York")
                ));

        Cities fetchedCities = cityController.getCities();

        assertThat(fetchedCities.getCities())
                .containsOnly(
                        new City(1, "Los Angeles"),
                        new City(2, "New York")
                );
    }
}