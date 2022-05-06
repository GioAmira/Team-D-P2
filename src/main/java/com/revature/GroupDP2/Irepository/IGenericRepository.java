package com.revature.GroupDP2.Irepository;

public interface IGenericRepository<T> {
    public void createOrUpdate(T t);
    public T getById(int t);
    public void delete(T t);
}
