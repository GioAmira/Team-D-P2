package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void create(Category category){

        categoryRepository.create(category);
    }
}
