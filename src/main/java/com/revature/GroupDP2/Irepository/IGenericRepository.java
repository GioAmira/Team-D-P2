package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;
import org.springframework.http.ResponseEntity;

public interface IGenericRepository<T> {
    Product create(T t);
    ResponseEntity<Product> update(T t);
    T getById(int t);
    Product delete(T t);
}
