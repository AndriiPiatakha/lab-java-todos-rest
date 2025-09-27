package com.itbulls.learnit.todoslab.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbulls.learnit.todoslab.dto.CreateTodoRequest;
import com.itbulls.learnit.todoslab.dto.UpdateTodoRequest;
import com.itbulls.learnit.todoslab.service.InMemoryTodoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Students will run this file using the "Test" button in the workspace.
 * We use MockMvc with a standalone controller; no server/ports required.
 */
public class TodoControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        TodoController controller = new TodoController(new InMemoryTodoService());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mapper = new ObjectMapper();
    }

    @Test
    void shouldCreateAndFetchTodo() throws Exception {
        // Create
        CreateTodoRequest req = new CreateTodoRequest("Write lab");
        String payload = mapper.writeValueAsString(req);

        String location = mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("Write lab"))
                .andExpect(jsonPath("$.done").value(false))
                .andReturn()
                .getResponse()
                .getHeader("Location");

        // Read back
        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Write lab"));
    }

    @Test
    void shouldListUpdateAndDelete() throws Exception {
        // Seed two todos
        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new CreateTodoRequest("A"))))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new CreateTodoRequest("B"))))
                .andExpect(status().isCreated());

        // List
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        // Update first to done=true
        UpdateTodoRequest upd = new UpdateTodoRequest();
        upd.setDone(true);
        mockMvc.perform(put("/todos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(upd)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.done").value(true));

        // Delete second
        mockMvc.perform(delete("/todos/2"))
                .andExpect(status().isNoContent());

        // Verify deletion
        mockMvc.perform(get("/todos/2"))
                .andExpect(status().isNotFound());
    }
}
