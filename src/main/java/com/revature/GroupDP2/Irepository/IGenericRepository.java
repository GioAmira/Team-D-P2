package com.revature.GroupDP2.Irepository;

import java.util.Optional;

public interface IGenericRepository<T> {
    void create(T t);
    void update(T t);
    Optional<T> getById(int t);
    void delete(T t);
}
