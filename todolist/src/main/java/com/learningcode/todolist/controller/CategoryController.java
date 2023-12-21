package com.learningcode.todolist.controller;

import com.learningcode.todolist.enums.Colour;
import com.learningcode.todolist.model.Category;
import com.learningcode.todolist.model.Task;
import com.learningcode.todolist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public String addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category was created";
    }

    @GetMapping("/getAllTasksByCategory")
    public Set<Task> getAllTasksByCategory(@RequestParam int categoryId){
        return categoryService.getAllTasksByCategory(categoryId);
    }

    @GetMapping("/getAll")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/deleteCategory")
    public String deleteCategory(@RequestParam int categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @PostMapping("/updateColour")
    public Category changeCategoryColour(@RequestParam int categoryId, @RequestParam Colour colour){
        return categoryService.updateCategoryColour(categoryId, colour);
    }
}
