package com.pknu.todo_p.repository;

import com.pknu.todo_p.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
