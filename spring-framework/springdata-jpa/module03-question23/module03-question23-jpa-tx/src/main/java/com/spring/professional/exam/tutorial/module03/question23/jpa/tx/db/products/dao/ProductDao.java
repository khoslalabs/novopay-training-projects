package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.dao;

import com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
