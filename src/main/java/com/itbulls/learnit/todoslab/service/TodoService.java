package com.itbulls.learnit.todoslab.service;

import java.util.List;
import java.util.Optional;

import com.itbulls.learnit.todoslab.model.Todo;

/**
 * Service boundary to manage Todos.
 * Students will implement the in-memory version.
 */
public interface TodoService {
    Todo create(String title);
    List<Todo> findAll();
    Optional<Todo> findById(Long id);
    Optional<Todo> update(Long id, String title, Boolean done);
    boolean delete(Long id);
}