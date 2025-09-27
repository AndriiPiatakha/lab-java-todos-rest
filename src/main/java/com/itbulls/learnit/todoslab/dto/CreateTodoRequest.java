package com.itbulls.learnit.todoslab.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Payload for creating a new Todo.
 */
public class CreateTodoRequest {
    @NotBlank(message = "title must not be blank")
    private String title;

    public CreateTodoRequest() {}
    public CreateTodoRequest(String title) { this.title = title; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
