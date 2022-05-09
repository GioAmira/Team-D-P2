package com.revature.GroupDP2.Irepository;

import java.util.List;

public interface IPaymentRepository<T> {

    public void save(T t);
    public void update(T t);
    public List<T> getAll();
    public T getById(Integer id);
    public void delete(T t);

}
