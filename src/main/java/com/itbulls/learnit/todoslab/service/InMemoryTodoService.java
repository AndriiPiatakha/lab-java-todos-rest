package com.itbulls.learnit.todoslab.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.itbulls.learnit.todoslab.model.Todo;


@Service
public class InMemoryTodoService implements TodoService {

    // TODO: create in-memory store (e.g., Map<Long, Todo>)
    // TODO: create id generator (e.g., AtomicLong)

    @Override
    public Todo create(String title) {
        // TODO: implement creation logic
        return null;
    }

    @Override
    public List<Todo> findAll() {
        // TODO: return all todos
        return Collections.emptyList();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        // TODO: return todo by id
        return Optional.empty();
    }

    @Override
    public Optional<Todo> update(Long id, String title, Boolean done) {
        // TODO: update todo if exists
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        // TODO: delete todo by id
        return false;
    }
}
