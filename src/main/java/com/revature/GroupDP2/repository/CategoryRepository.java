package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICategoryRepository;
import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.Optional;


public class CategoryRepository implements ICategoryRepository<Category> {

    private TransactionManager transactionManager;
    private Session session;

    public CategoryRepository(){
        transactionManager = null;
        session = null;
    }
    public CategoryRepository(TransactionManager transactionManager, Session session){
        this.transactionManager = transactionManager;
        this.session = session;
    }

    @Override
    public Category getByCategoryName(Category category) {
        if (transactionManager != null && session != null){
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
        if (transactionManager != null && session != null){
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
        if (transactionManager != null && session != null){
            Transaction transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    @Override
    public Optional<Category> getById(int t) {
        Category category = null;
        if (transactionManager != null && session != null){
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
        if (transactionManager != null && session != null){
            Transaction transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }
}
