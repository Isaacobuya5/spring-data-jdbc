package com.todoapp.demo.repositories;

import com.todoapp.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class JdbcTodoRepository implements TodoRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Todo> findAll() {
        return jdbcTemplate.query("select * from Todo", this::mapRowToTodo);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        List<Todo> results = jdbcTemplate.query(
                "select * from Todo where id=?",
                this::mapRowToTodo,
                id
        );
        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public Todo save(Todo todo) {
        jdbcTemplate.update(
                "insert into Todo (id, name, description) values (?, ? ,?)",
                todo.getId(),
                todo.getName(),
                todo.getDescription(),
                todo.getIsCompleted()
        );
        return todo;
    }

    private Todo mapRowToTodo(ResultSet row, int rowNum) throws SQLException {
        return new Todo(
                row.getLong("id"),
                row.getString("name"),
                row.getString("description"),
                row.getBoolean("isCompleted"),
                row.getDate("createdDate"));
    };
}
