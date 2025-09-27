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

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // TODO: implement endpoints:
    // GET /todos
    // GET /todos/{id}
    // POST /todos
    // PUT /todos/{id}
    // DELETE /todos/{id}
}
