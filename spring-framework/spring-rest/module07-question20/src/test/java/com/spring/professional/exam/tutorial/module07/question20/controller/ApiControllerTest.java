package com.spring.professional.exam.tutorial.module07.question20.controller;

import com.spring.professional.exam.tutorial.module07.question20.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question20.ds.CustomerCriteria;
import com.spring.professional.exam.tutorial.module07.question20.ds.Customers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ApiControllerTest {

    private static final Customer CUSTOMER_1 = new Customer(1, "CC", "Caitlin", "Chen");
    private static final Customer CUSTOMER_2 = new Customer(2, "KT", "Kamila", "Terry");
    private static final Customer CUSTOMER_3 = new Customer(3, "EH", "Eve", "Harrell");
    private static final Customer CUSTOMER_4 = new Customer(null, "JD", "John", "Doe");
    private static final Customer CUSTOMER_5 = new Customer(null, "AH", "Adalyn", "Hooper");
    private static final Customer CUSTOMER_6 = new Customer(null, "CF", "Chase", "Freeman");

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldListCustomersAsObject() {
        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_2,
                CUSTOMER_3
        );
    }

    @Test
    public void shouldListCustomersAsEntity() {
        ResponseEntity<Customers> entity = restTemplate.getForEntity("/api/customers", Customers.class);

        assertEquals(OK, entity.getStatusCode());
        assertThat(entity.getBody().getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_2,
                CUSTOMER_3
        );
    }

    @Test
    public void shouldGetCustomerAsObject() {
        Customer customer = restTemplate.getForObject("/api/customers/2", Customer.class);

        assertEquals(CUSTOMER_2, customer);
    }

    @Test
    public void shouldGetCustomersCountAsHeader() {
        HttpHeaders httpHeaders = restTemplate.headForHeaders("/api/customers");

        assertEquals("3", httpHeaders.getFirst("Customers-Count"));
    }

    @Test
    @DirtiesContext
    public void shouldCreateCustomerAndReturnLocation() {
        URI uri = restTemplate.postForLocation("/api/customers", CUSTOMER_4);

        assertEquals(URI.create("/api/customers/4"), uri);
    }

    @Test
    @DirtiesContext
    public void shouldCreateCustomerAndReturnEntity() {
        ResponseEntity<Customer> entity = restTemplate.postForEntity("/api/customers", CUSTOMER_4, Customer.class);

        assertEquals(OK, entity.getStatusCode());
        assertEquals(URI.create("/api/customers/4"), entity.getHeaders().getLocation());
        assertEquals(new Customer(4, CUSTOMER_4.getCode(), CUSTOMER_4.getFirstName(), CUSTOMER_4.getLastName()), entity.getBody());
    }

    @Test
    @DirtiesContext
    public void shouldCreateCustomerAndReturnObject() {
        Customer customer = restTemplate.postForObject("/api/customers", CUSTOMER_4, Customer.class);

        assertEquals(new Customer(4, CUSTOMER_4.getCode(), CUSTOMER_4.getFirstName(), CUSTOMER_4.getLastName()), customer);
    }

    @Test
    @DirtiesContext
    public void shouldBatchUpdateCustomers() {
        restTemplate.put("/api/customers", Arrays.asList(CUSTOMER_4, CUSTOMER_5, CUSTOMER_6));

        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                new Customer(4, CUSTOMER_4.getCode(), CUSTOMER_4.getFirstName(), CUSTOMER_4.getLastName()),
                new Customer(5, CUSTOMER_5.getCode(), CUSTOMER_5.getFirstName(), CUSTOMER_5.getLastName()),
                new Customer(6, CUSTOMER_6.getCode(), CUSTOMER_6.getFirstName(), CUSTOMER_6.getLastName())
        );
    }

    @Test
    @DirtiesContext
    public void shouldPutCustomerAtId() {
        restTemplate.put("/api/customers/6", CUSTOMER_6);

        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_2,
                CUSTOMER_3,
                new Customer(6, CUSTOMER_6.getCode(), CUSTOMER_6.getFirstName(), CUSTOMER_6.getLastName())
        );
    }

    @Test
    @DirtiesContext
    public void shouldPutCustomerAtIdWithUriVariables() {
        restTemplate.put("/api/customers/{id}", CUSTOMER_6, 6);

        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_2,
                CUSTOMER_3,
                new Customer(6, CUSTOMER_6.getCode(), CUSTOMER_6.getFirstName(), CUSTOMER_6.getLastName())
        );
    }

    @Test
    @DirtiesContext
    public void shouldDeleteAllCustomers() {
        restTemplate.delete("/api/customers");

        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertEquals(0, customers.getCustomers().size());
    }

    @Test
    @DirtiesContext
    public void shouldGetNoContentOnFirstDelete() {
        HttpStatus httpStatus = restTemplate.execute("/api/customers", HttpMethod.DELETE, null, ClientHttpResponse::getStatusCode);

        assertEquals(NO_CONTENT, httpStatus);
    }

    @Test
    @DirtiesContext
    public void shouldGetNotFoundOnSecondDelete() {
        restTemplate.delete("/api/customers");

        HttpStatus httpStatus = restTemplate.execute("/api/customers", HttpMethod.DELETE, null, ClientHttpResponse::getStatusCode);

        assertEquals(NOT_FOUND, httpStatus);
    }

    @Test
    @DirtiesContext
    public void shouldGetNotFoundWhenDeletingNonExistingCustomer() {
        HttpStatus httpStatus = restTemplate.execute("/api/customers/99", HttpMethod.DELETE, null, ClientHttpResponse::getStatusCode);

        assertEquals(NOT_FOUND, httpStatus);
    }

    @Test
    @DirtiesContext
    public void shouldDeleteSecondCustomer() {
        restTemplate.delete("/api/customers/{id}", 2);

        Customers customers = restTemplate.getForObject("/api/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_3
        );
    }

    @Test
    public void shouldFindCustomersWithLetterAInFirstName() {
        CustomerCriteria customerCriteria = new CustomerCriteria("%a%");

        ResponseEntity<Customers> customersEntity = restTemplate.exchange("/api/customers/search", HttpMethod.POST, new HttpEntity<>(customerCriteria), Customers.class);

        assertEquals(OK, customersEntity.getStatusCode());
        assertThat(customersEntity.getBody().getCustomers()).containsExactly(
                CUSTOMER_1,
                CUSTOMER_2
        );
    }

    @Test
    public void shouldNotFindAnyCustomers() {
        CustomerCriteria customerCriteria = new CustomerCriteria("%X%");

        ResponseEntity<Customers> customersEntity = restTemplate.exchange("/api/customers/search", HttpMethod.POST, new HttpEntity<>(customerCriteria), Customers.class);

        assertEquals(NOT_FOUND, customersEntity.getStatusCode());
        assertNull(customersEntity.getBody());
    }
}