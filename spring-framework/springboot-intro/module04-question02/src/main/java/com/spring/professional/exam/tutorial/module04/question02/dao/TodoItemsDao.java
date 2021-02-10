package com.spring.professional.exam.tutorial.module04.question02.dao;

import com.spring.professional.exam.tutorial.module04.question02.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
