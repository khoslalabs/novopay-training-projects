package com.spring.professional.exam.tutorial.module04.question05.dao;

import com.spring.professional.exam.tutorial.module04.question05.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
