package com.learningcode.todolist.service;

// Contains business logic and acts as a bridge between controllers and repositories

import com.learningcode.todolist.model.Task;

import java.util.List;

public interface TaskService {
    // Create task (send data to the db)
    public Task createTask(Task task);

    // Get All Tasks
    public List<Task> getAllTasks();

    //Mark task complete
    public Task updateTaskIsComplete(int taskId);

    // Change Task name
    public Task changeTaskName(int taskId, String taskName);

    // Add category to Task
    public Task addCategoryToTask(int taskId, int categoryId);

    // Delete Category from Task
    public Task deleteCategoryFromTask(int taskId, int categoryId);

    // Delete Task
    public String deleteTask(int taskId);
}
