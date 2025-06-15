package com.pknu.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.todo.entity.Todo;
import com.pknu.todo.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*") // 프론트와 연동 시 CORS 허용
public class TdController {

    @Autowired
    private TodoRepository todoRepository;

    // ✅ 모든 할 일 조회
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // ✅ 새로운 할 일 추가
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // ✅ 완료 상태 토글
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setCompleted(!todo.isCompleted()); // 완료 상태 반전
            return todoRepository.save(todo);
        }
        return null;
    }

    // ✅ 할 일 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}

