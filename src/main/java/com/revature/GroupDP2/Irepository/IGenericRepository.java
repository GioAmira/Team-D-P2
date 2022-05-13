package com.revature.GroupDP2.Irepository;


import com.revature.GroupDP2.model.Product;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {
    void create(T t);
    void update(T t);
    Optional<T> getById(int t);

    List<T>getAll(T t);
    void delete(T t);
}
