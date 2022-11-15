package com.todoapp.demo.repositories;

import com.todoapp.demo.model.Todo;

import java.util.Optional;

public interface TodoRepository {

    Iterable<Todo> findAll();

    Optional<Todo> findById(Long id);

    Todo save(Todo todo);
}
