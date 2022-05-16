package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICategoryRepository;
import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;


import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CategoryRepository implements ICategoryRepository<Category>, Lifecycle{

    private boolean running = false;
    private StorageManager storageManager;
    private Session session;

    public CategoryRepository(){
        session = null;
    }
    @Autowired
    public CategoryRepository(StorageManager storageManager){
        this.storageManager = storageManager;
    }

    @Override
    public Category getByCategoryName(Category category) {
        if (session != null){
            TypedQuery<Category> query = session.createQuery("FROM Category WHERE categoryName = :categoryName",Category.class);
            query.setParameter("categoryName", category.getCategoryName());
            category = query.getSingleResult();
        }
        else{
            //throw an exception
        }
        return category;
    }

    @Override
    public void create(Category category) {
        System.out.println("we are here and maybe session is null");
        if (session != null){
            System.out.println("category is about to be added");
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    @Override
    public void update(Category category) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }
    public void something(){
        System.out.println("something");
    }
    @Override
    public Optional<Category> getById(int t) {
        Category category = null;
        if (session != null){
            Transaction transaction = session.beginTransaction();
            category = session.get(Category.class,t);
            transaction.commit();
        }
        else{
            //throw an exception
        }
        return Optional.ofNullable(category);
    }
    @Override
    public void delete(Category category) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    //ADD METHOD LATER
    @Override
    public List<Category> getAll() {
        TypedQuery<Category> query = session.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    @Override
    public void start() {
        running = true;
        this.session = storageManager.getSession();
    }

    @Override
    public void stop() {
        running = false;
        this.session.close();

    }

    @Override
    public boolean isRunning() {
        return running;
    }

}


