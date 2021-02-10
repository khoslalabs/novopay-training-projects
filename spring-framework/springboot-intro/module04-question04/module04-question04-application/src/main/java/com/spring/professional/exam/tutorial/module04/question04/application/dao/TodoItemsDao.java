package com.spring.professional.exam.tutorial.module04.question04.application.dao;

import com.spring.professional.exam.tutorial.module04.question04.application.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
