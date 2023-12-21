package com.learningcode.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="task")
public class Task {

    @Id // like defining the primary key in SQL
    @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Like auto increment in SQL
    private int taskId;

    private String taskName;
    private LocalDate dueDate;
    private boolean isCompleted;

    @ManyToMany(mappedBy = "tasks")
    private Set<Category> categories = new HashSet<>();


    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
