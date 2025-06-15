package com.pknu.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq_generator")
    @SequenceGenerator(
        name = "todo_seq_generator",
        sequenceName = "TODO_SEQ",
        allocationSize = 1
    )
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "COMPLETED", nullable = false)
    private boolean completed = false;

    public Todo() {}

    public Todo(String title) {
        this.title = title;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
