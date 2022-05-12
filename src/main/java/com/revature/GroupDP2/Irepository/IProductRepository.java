package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;



import com.revature.GroupDP2.model.Product;

public interface IProductRepository<T> extends IGenericRepository<Product>{

    Product getByUserId(int l);

    Product getByCategoryId(int l);

    Product getByProductName(Product product);

    Product getByUserId(Long id);

    Product getByCategoryId(Long l);
}