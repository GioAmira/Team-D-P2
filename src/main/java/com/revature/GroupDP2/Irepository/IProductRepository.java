package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

public interface IProductRepository extends IGenericRepository<Product>{

    public Product getByUserId(Long id);

    Product create(Product p);

    void update(Product p);

    Product getById(int t);

    Product delete(Product p);

    Product getByCategoryId(Long l);
}
