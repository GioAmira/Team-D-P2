package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

import java.util.Optional;

public interface IGenericRepository<T> {
    Product create(T t);
    Object update(T t);
    Optional<T> getById(int t);
    void delete(T t);
}
