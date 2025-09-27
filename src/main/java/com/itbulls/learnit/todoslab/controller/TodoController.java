package com.itbulls.learnit.todoslab.controller;

import java.net.URI;
import java.util.List;


import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.itbulls.learnit.todoslab.dto.CreateTodoRequest;
import com.itbulls.learnit.todoslab.dto.UpdateTodoRequest;
import com.itbulls.learnit.todoslab.model.Todo;
import com.itbulls.learnit.todoslab.service.TodoService;

/**
 * REST controller for /todos CRUD.
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    /** GET /todos -> list all */
    @GetMapping
    public List<Todo> all() {
        return service.findAll();
    }

    /** GET /todos/{id} -> find one or 404 */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> one(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** POST /todos -> create, return 201 + Location header */
    @PostMapping
    public ResponseEntity<Todo> create(@Valid @RequestBody CreateTodoRequest req,
                                       UriComponentsBuilder uriBuilder) {
        Todo created = service.create(req.getTitle());
        URI location = uriBuilder.path("/todos/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    /** PUT /todos/{id} -> update title/done, or 404 if missing */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id,
                                       @Valid @RequestBody UpdateTodoRequest req) {
        return service.update(id, req.getTitle(), req.getDone())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** DELETE /todos/{id} -> 204 or 404 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
