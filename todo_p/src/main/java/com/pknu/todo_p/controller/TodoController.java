package com.pknu.todo_p.controller;

import com.pknu.todo_p.entity.Todo;
import com.pknu.todo_p.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        service.deleteById(id);
    }
}
