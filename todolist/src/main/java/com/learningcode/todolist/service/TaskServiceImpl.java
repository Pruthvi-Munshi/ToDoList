package com.learningcode.todolist.service;

import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{
    // Marks a constructor, field, or method to be autowired by Spring's dependency injection. This annotation removes the need for explicit setter methods and can be used on a constructor to autowire the constructor itself.
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
