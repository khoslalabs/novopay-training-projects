package com.spring.professional.exam.tutorial.module04.question03.autoconfiguration.dao;

import com.spring.professional.exam.tutorial.module04.question03.autoconfiguration.ds.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
