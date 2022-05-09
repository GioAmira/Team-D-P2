package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;


public abstract class ProductRepository implements IProductRepository {

    private TransactionManager transactionManager;
    private Session session;

    public ProductRepository(TransactionManager transactionManager, Session session) {
        this.transactionManager = transactionManager;
        this.session = session;
    }


    @Override
    public Product create(Product p) {
        Transaction transaction = transactionManager.beginTransaction();
        session.save(p);
        transaction.commit();
        return p;
    }

    @Override
    public void update(Product p) {
        Transaction transaction = transactionManager.beginTransaction();
        session.update(p);
        transaction.commit();
    }

    @Override
    public Product getById(int t) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE id = :id", Product.class);
        query.setParameter("id", t);
        return query.getSingleResult();
    }

    @Override
    public Product delete(Product p) {
        Transaction transaction = transactionManager.beginTransaction();
        session.delete(p);
        transaction.commit();
        return p;
    }

    @Override
    public Product getByCategoryId(Long id) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE categoryId = :categoryId", Product.class);
        query.setParameter("categoryId", id);
        return query.getSingleResult();
    }



}