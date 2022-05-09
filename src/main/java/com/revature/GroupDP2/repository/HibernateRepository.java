package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.model.Product;

import java.util.List;

public interface HibernateRepository<P> {
    public void save(P p);
    public List<P> getAll();
    Public P = new Public(); void getById(Integer id);

    Product getById(Long id);

    class Public {
    }
}
