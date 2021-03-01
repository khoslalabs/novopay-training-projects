package com.spring.professional.exam.tutorial.module04.question39.ds;



import java.util.Objects;


public class Cities {
    private Iterable<City> cities;

    public Cities() {
    }

    public Cities(Iterable<City> cities) {
        this.cities = cities;
    }

    public Iterable<City> getCities() {
        return cities;
    }

    public void setCities(Iterable<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cities cities1 = (Cities) o;
        return Objects.equals(cities, cities1.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities);
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cities=" + cities +
                '}';
    }
}
