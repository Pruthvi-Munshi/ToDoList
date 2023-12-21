package com.learningcode.todolist.service;

import com.learningcode.todolist.model.Category;
import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.repository.CategoryRepository;
import com.learningcode.todolist.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService{
    // Marks a constructor, field, or method to be autowired by Spring's dependency injection. This annotation removes the need for explicit setter methods and can be used on a constructor to autowire the constructor itself.
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task updateTaskIsComplete(int taskId){
        //Fetch task
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));

        task.setIsCompleted(!task.getIsCompleted());

        return taskRepository.save(task);
    }

    @Override
    public Task changeTaskName(int taskId, String taskName){
        // Fetch Task
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found with ID: " + taskId));

        task.setTaskName(taskName);

        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task addCategoryToTask(int taskId, int categoryId){
        // Define category & Task Test
        Set<Category> categories = null;
        Set<Task> tasks = null;

        // Fetch Task & Category from db
        Task task = taskRepository.findById(taskId).get();
        Category category = categoryRepository.findById(categoryId).get();

        // Add category to task list of categories
        categories = task.getCategories();
        categories.add(category);

        // Add task to category
        tasks = category.getTasks();
        tasks.add(task);

        task.setCategories(categories);
        category.setTask(tasks);

        categoryRepository.save(category);
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task deleteCategoryFromTask(int taskId, int categoryId){
        // Define category & task test
        Set<Category> categories = null;
        Set<Task> tasks = null;

        // Fetch Task & Category from db
        Task task = taskRepository.findById(taskId).get();
        Category category = categoryRepository.findById(categoryId).get();

        // Add category to task list of categories
        categories = task.getCategories();
        categories.remove(category);

        // Add task to category
        tasks = category.getTasks();
        tasks.remove(task);

        task.setCategories(categories);
        category.setTask(tasks);

        categoryRepository.save(category);
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public String deleteTask(int taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found with ID: " + taskId));

        // Remove the task from associated categories
        for (Category category : task.getCategories()) {
            category.getTasks().remove(task);
        }

        taskRepository.deleteById(taskId);
        return "Successfully Deleted";
    }
}
