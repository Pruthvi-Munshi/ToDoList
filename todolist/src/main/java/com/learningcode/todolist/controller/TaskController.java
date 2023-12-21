package com.learningcode.todolist.controller;

// Contains classes annotated with @RestController that handle incoming HTTP requests

import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAll")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/addCategory")
    public Task addCategoryToTask(@RequestParam int taskId, @RequestParam int categoryId){
        return taskService.addCategoryToTask(taskId, categoryId);
    }

    @PutMapping("/deleteCategory")
    public Task deleteCategoryFromTask(@RequestParam int taskId, @RequestParam int categoryId){
        return taskService.deleteCategoryFromTask(taskId, categoryId);
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask(@RequestParam int taskId){
        return taskService.deleteTask(taskId);
    }
}
