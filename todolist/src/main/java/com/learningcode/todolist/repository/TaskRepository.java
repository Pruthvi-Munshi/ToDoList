package com.learningcode.todolist.repository;

// Houses classes that interact with the database, usually using Spring Data JPA
// In other words this is where we call the database

import com.learningcode.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
