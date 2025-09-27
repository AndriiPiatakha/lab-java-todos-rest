# Lab: Mini REST API (Spring MVC on Java 21)

**Goal:** Build CRUD endpoints for `/todos`:
- `GET /todos`
- `GET /todos/{id}`
- `POST /todos`
- `PUT /todos/{id}`
- `DELETE /todos/{id}`

## How to run in the Udemy Lab
- Open `src/test/java/com/example/todos/TodoControllerTest.java`
- Click **Test** (the IDE runs MockMvc tests; no ports or external tools needed).

## What you must implement / improve
- The in-memory service is provided. You can enhance validations and error handling.
- Return proper HTTP statuses and JSON bodies (already scaffolded in the controller).
- Optional: ensure title cannot be blank on create/update.

## Tips
- Keep package/import lines intact.
- Do not rename Makefile targets.
- You do **not** need to start a real web server to complete this lab.