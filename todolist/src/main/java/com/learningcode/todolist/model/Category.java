package com.learningcode.todolist.model;

// Contains classes representing data entities (e.g. JPA entities or DTOs)
    // JPA (Java persistence API) entities are Java classes that represent objects in you application and are mapped to
    //  database tables
    // DTOs (Data transfer Objects) are objects used to transfer data between different layers of an application, such as
    //  between the frontend and the backend

// Spring Boot makes extensive use of annotations to simplify the configuration and development of Spring-based applications.
// Annotations are markers added to Java classes or methods that provide additional information to the Spring framework.

import jakarta.persistence.*;

@Entity // Indicates that this class is a JPA entity and should be mapped to a database table.
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "task_id")
    private int taskId;

    private String categoryName;

    // GETTERS
    public int getCategoryId(){
        return categoryId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getCategoryName(){
        return categoryName;
    }

    // SETTERS
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", taskId=" + taskId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
