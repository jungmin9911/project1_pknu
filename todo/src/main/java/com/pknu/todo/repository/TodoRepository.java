package com.pknu.todo.repository;

import com.pknu.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 기본 CRUD는 이 인터페이스로 자동 구현됨
}

