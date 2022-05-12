package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements IProductRepository<Product> {

    private final StorageManager storageManager;
    private Session session;
    private boolean running = false;


    @Autowired
    public ProductRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public Product create(Product product) {
        return product;
    }

    @Override
    public Product update(Product product) {
        //TODO: Write me!
        return product;

    }

    @Override
    public Optional<Product> getById(int t) {
        return Optional.empty();
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product getByUserId(int l) {
        return null;
    }

    @Override
    public Product getByCategoryId(int l) {
        return null;
    }

    @Override
    public Product save(Product product) {
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        return product;
    }

    @Override
    public List<Product> getAll() {
        String hql = "FROM Product";
        TypedQuery<Product> query = session.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Object getById(Integer id) {
        String hql = "FROM Product WHERE id = :id";
        TypedQuery<Product> query = session.createQuery(hql);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void start() {
        this.session = storageManager.getSession();
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    public Product getByProductName(String productName) {
        return null;
    }
}