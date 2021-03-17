package com.spring.professional.exam.tutorial.module07.question07.controller;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;
import com.spring.professional.exam.tutorial.module07.question07.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question07.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question07.ds.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.rometools.rome.feed.rss.Content.TEXT;
import static org.springframework.http.MediaType.*;

@RestController
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
    public Iterable<Customer> listCustomersJSON() {
        return customersDao.findAll();
    }

    @GetMapping(value = "/customers", produces = APPLICATION_XML_VALUE)
    public Customers listCustomersXML() {
        return new Customers(customersDao.findAll());
    }

    @GetMapping(value = "/customers", produces = APPLICATION_RSS_XML_VALUE)
    public Channel listCustomersRSS() throws MalformedURLException {
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("Customers RSS");
        channel.setDescription("Example RSS Feed in Spring Boot");
        channel.setLink(
                ServletUriComponentsBuilder.fromCurrentRequest().build()
                        .toUri().toURL().toExternalForm()
        );

        List<Item> customersRssItems = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(this::customerAsRssItem)
                .collect(Collectors.toList());

        channel.setItems(customersRssItems);
        return channel;
    }

    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Customer createCustomerJSON(@RequestBody @Valid Customer customer) {
        return customersDao.save(customer);
    }

    @PostMapping(value = "/customers", consumes = APPLICATION_XML_VALUE, produces = APPLICATION_XML_VALUE)
    public Customer createCustomerXML(@RequestBody @Valid Customer customer) {
        return customersDao.save(customer);
    }

    private Item customerAsRssItem(Customer customer) {
        Item item = new Item();
        Content content = new Content();
        content.setType(TEXT);
        content.setValue(customer.toString());
        item.setContent(content);
        return item;
    }
}
