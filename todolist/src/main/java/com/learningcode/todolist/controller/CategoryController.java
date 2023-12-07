package com.learningcode.todolist.controller;

import com.learningcode.todolist.model.Category;
import com.learningcode.todolist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
