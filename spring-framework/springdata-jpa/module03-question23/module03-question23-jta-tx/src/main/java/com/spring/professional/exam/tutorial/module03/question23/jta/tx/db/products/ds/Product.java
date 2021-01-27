package com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.products.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
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

    public Product(int id, String name, int quantity, float price, boolean available) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
