package com.learningcode.todolist.service;

import com.learningcode.todolist.enums.Colour;
import com.learningcode.todolist.model.Category;
import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public String deleteCategory(int categoryId){
        categoryRepository.deleteById(categoryId);
        return "Category deleted";
    }

    @Override
    public Category updateCategoryColour(int categoryId, Colour colour){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));

        category.setColour(colour);

        return categoryRepository.save(category);
    }

    @Override
    public Set<Task> getAllTasksByCategory(int categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));

        return category.getTasks();
    }

}
