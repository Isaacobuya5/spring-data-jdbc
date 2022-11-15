package com.todoapp.demo.dao;

import com.todoapp.demo.model.Todo;
import com.todoapp.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TodoImpl implements TodoDao{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }
}
