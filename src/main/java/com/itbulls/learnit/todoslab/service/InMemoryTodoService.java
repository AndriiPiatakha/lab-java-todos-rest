package com.itbulls.learnit.todoslab.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.itbulls.learnit.todoslab.model.Todo;


/**
 * Simple in-memory implementation.
 * Thread-safe enough for lab purposes.
 */
@Service
public class InMemoryTodoService implements TodoService {

    private final Map<Long, Todo> store = new ConcurrentHashMap<>();
    private final AtomicLong idSeq = new AtomicLong(0);

    @Override
    public Todo create(String title) {
        // TODO: validate title (non-null, non-blank) if desired
        long id = idSeq.incrementAndGet();
        Todo todo = new Todo(id, title, false);
        store.put(id, todo);
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Todo> update(Long id, String title, Boolean done) {
        Todo existing = store.get(id);
        if (existing == null) return Optional.empty();

        if (title != null && !title.isBlank()) {
            existing.setTitle(title);
        }
        if (done != null) {
            existing.setDone(done);
        }
        return Optional.of(existing);
    }

    @Override
    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
