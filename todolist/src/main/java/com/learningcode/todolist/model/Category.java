package com.learningcode.todolist.model;

// Contains classes representing data entities (e.g. JPA entities or DTOs)
    // JPA (Java persistence API) entities are Java classes that represent objects in you application and are mapped to
    //  database tables
    // DTOs (Data transfer Objects) are objects used to transfer data between different layers of an application, such as
    //  between the frontend and the backend

// Spring Boot makes extensive use of annotations to simplify the configuration and development of Spring-based applications.
// Annotations are markers added to Java classes or methods that provide additional information to the Spring framework.

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningcode.todolist.enums.Colour;
import jakarta.persistence.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity // Indicates that this class is a JPA entity and should be mapped to a database table.
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "task_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<Task> tasks = new HashSet<>();


    private String categoryName;
    private Colour colour;

    // GETTERS
    public int getCategoryId(){
        return categoryId;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Colour getColour() {
        return colour;
    }

    public String getCategoryName(){
        return categoryName;
    }

    // SETTERS
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setTask(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", task=" + tasks +
                ", categoryName='" + categoryName + '\'' +
                ", colour=" + colour +
                '}';
    }
}
