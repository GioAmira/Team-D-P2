package com.revature.GroupDP2.Irepository;

public interface IGenericRepository<T> {
    public void create(T t);
    public void update(T t);
    public T getById(int t);
    public void delete(T t);
}
