package com.learningcode.todolist.controller;

// Contains classes annotated with @RestController that handle incoming HTTP requests

import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        taskService.createTask(task);
        return "The task was added";
    }
}
