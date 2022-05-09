package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.Optional;


public class ProductRepository implements IProductRepository<Product> {

    private TransactionManager transactionManager;
    private Session session;

    public ProductRepository(TransactionManager transactionManager, Session session) {
        this.transactionManager = transactionManager;
        this.session = session;
    }


    @Override
    public void create(Product p) {
        Transaction transaction = transactionManager.beginTransaction();
        session.save(p);
        transaction.commit();
    }

    @Override
    public void update(Product p) {
        Transaction transaction = transactionManager.beginTransaction();
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
        Transaction transaction = transactionManager.beginTransaction();
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
}