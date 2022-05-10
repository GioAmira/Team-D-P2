package com.revature.GroupDP2.Irepository;

public interface ICategoryRepository<Category> extends IGenericRepository<Category>{
    Category getByCategoryName (Category category);
}
