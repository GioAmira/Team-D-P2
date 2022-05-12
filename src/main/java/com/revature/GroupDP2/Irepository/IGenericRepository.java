package com.revature.GroupDP2.Irepository;


import com.revature.GroupDP2.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IGenericRepository<T> {
    Product create(T t);
    ResponseEntity<Product> update(T t);
    Optional<Product> getById(int t);
    void delete(T t);

import java.util.Optional;

public interface IGenericRepository<T> {
    void create(T t);
    void update(T t);
    Optional<T> getById(int t);
    void delete(T t);
}
