package com.lab3springbootTDD.controller;

import com.lab3springbootTDD.Service.CategoryService;
import com.lab3springbootTDD.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/hello")
    @ResponseBody
    public String sayHello() {
        return "Hola";
    }

    @GetMapping(value = "/categories")
    @ResponseBody
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = categoryService.getAll();
        return categories;
    }
}