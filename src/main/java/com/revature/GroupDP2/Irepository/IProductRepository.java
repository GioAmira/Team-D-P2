package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

public interface IProductRepository<T> extends IGenericRepository<Product>{

    Product getByUserId(int l);

    Product getByCategoryId(int l);
}
