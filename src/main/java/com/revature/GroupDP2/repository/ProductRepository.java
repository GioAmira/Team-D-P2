package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository<Product>, Lifecycle {

    private final StorageManager storageManager;
    private Session session;
    private boolean running=false;
    @Autowired
    public ProductRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }


    @Override
    public void create(Product p) {
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
    }

    @Override
    public void update(Product p) {
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
    }

    @Override
    public Optional<Product> getById(int t) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE id = :id", Product.class);
        query.setParameter("id", t);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void delete(Product p) {
        Transaction transaction = session.beginTransaction();
        session.delete(p);
        transaction.commit();
    }

    @Override
    public Product getByCategoryId(int id) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE categoryId = :categoryId", Product.class);
        query.setParameter("categoryId", id);
        return query.getSingleResult();
    }

    @Override
    public Product getByUserId(int l) {
        return null;
    }

    @Override
    public void start() {
        this.session=storageManager.getSession();
        running=true;
    }

    @Override
    public void stop() {
    running=false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}