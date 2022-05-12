package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.Optional;


@Component
public class ProductRepository implements IProductRepository<Product>, Lifecycle {

    private boolean running = false;
    private StorageManager storageManager;
    private Session session;

    public ProductRepository(){
        session = null;
    }
    @Autowired
    public ProductRepository(StorageManager storageManager){
        this.storageManager = storageManager;
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
    public void getByProductName(Product product) {
        if (session != null) {
            TypedQuery<Product> query = session.createQuery("FROM Product WHERE productName = :productName", Product.class);
            query.setParameter("productName", product.getProductName());
            product = query.getSingleResult();
        } else {
            //throw an exception
        }

    }

    @Override
    public Product getByUserId(Long id) {
        return null;
    }

    @Override
    public void create(Product product) {
        System.out.println("we are here and maybe session is null");
        if (session != null){
            System.out.println("category is about to be added");
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    @Override
    public void update(Product product) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        }
        else{
            //throw an exception
        }

    }

    @Override
    public Optional<Product> getById(int t) {
        Product product = null;
        if (session != null){
            Transaction transaction = session.beginTransaction();
            product = session.get(Product.class,t);
            transaction.commit();
        }
        else{
            //throw an exception
        }
        return Optional.ofNullable(product);
    }

    @Override
    public void delete(Product product) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }
        else{
            //throw an exception
        }

    }

    @Override
    public Product getByCategoryId(Long l) {
        return null;
    }

    @Override
    public void start() {
        running = true;
        this.session = storageManager.getSession();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return running;
    }


}