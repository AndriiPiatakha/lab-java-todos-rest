package com.itbulls.learnit.todoslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point. In the lab we don't need to run an actual HTTP server to test
 * endpoints; tests use MockMvc. Running this class will start Spring anyway.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
