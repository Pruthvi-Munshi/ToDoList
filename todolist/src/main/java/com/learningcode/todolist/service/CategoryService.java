package com.learningcode.todolist.service;

import com.learningcode.todolist.enums.Colour;
import com.learningcode.todolist.model.Category;
import com.learningcode.todolist.model.Task;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    // Create a category
    public Category createCategory(Category category);

    public Set<Task> getAllTasksByCategory(int categoryId);

    public List<Category> getAllCategories();

    public String deleteCategory(int categoryId);

    public Category updateCategoryColour(int categoryId, Colour colour);
}
