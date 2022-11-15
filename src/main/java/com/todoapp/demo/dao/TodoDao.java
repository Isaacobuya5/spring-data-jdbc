package com.todoapp.demo.dao;

import com.todoapp.demo.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDao {

    Todo save(Todo todo);

    Optional<Todo> findById(Long id);

    Iterable<Todo> findAll();
}
