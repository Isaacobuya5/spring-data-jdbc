package com.todoapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Todo {

    private Long id;

    private String name;

    private String description;

    private Boolean isCompleted = false;

    private Date createdDate = new Date();

}
