package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Product {
    @Id
    private int id;
    private String name;
    private int quantity;
    private float price;
    private boolean available;

    @SuppressWarnings("unused")
    public Product() {
    }
}
