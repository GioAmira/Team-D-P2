package com.revature.GroupDP2.controllers;


import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public void create(@RequestBody Category category){

        categoryService.create(category);
    }

    @PutMapping
    public void update(@RequestBody Category category){

        categoryService.update(category);
    }

    @DeleteMapping
    public void delete (@RequestBody Category category){

        categoryService.delete(category);
    }

    @GetMapping
    public List<Category> getAll(){

        return categoryService.getAll();
    }


}
