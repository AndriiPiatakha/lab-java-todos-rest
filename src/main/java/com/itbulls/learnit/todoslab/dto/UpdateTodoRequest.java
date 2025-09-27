package com.itbulls.learnit.todoslab.dto;

/**
 * Payload for updating an existing Todo.
 * Fields are optional; if null, the field is not changed.
 */
public class UpdateTodoRequest {
    private String title;   // optional
    private Boolean done;   // optional

    public UpdateTodoRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean getDone() { return done; }
    public void setDone(Boolean done) { this.done = done; }
}
