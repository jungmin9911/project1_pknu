package com.pknu.todo_p.service;

import com.pknu.todo_p.entity.Todo;
import com.pknu.todo_p.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
