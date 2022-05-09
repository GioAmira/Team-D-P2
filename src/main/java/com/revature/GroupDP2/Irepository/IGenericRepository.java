package com.revature.GroupDP2.Irepository;

public interface IGenericRepository<T> {
    void create(T t);
    void update(T t);
    T getById(int t);
    void delete(T t);
}
