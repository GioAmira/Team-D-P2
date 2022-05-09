package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IUserRepository;
import com.revature.GroupDP2.util.TransactionManager;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private TransactionManager transactionManager;
    private Session session;
    //dependency injection via constructor
    public UserRepository(TransactionManager transactionManager,Session session) {
        this.transactionManager = transactionManager;
        this.session =session;
    }


    @Override
    public void create(User o) {
        Transaction transaction = transactionManager.beginTransaction();
        session.save(o);
        transaction.commit();
    }

    @Override
    public void update(User o) {
        Transaction transaction = transactionManager.beginTransaction();
        session.update(o);
        transaction.commit();
    }

    //maybe we want to return an optional?
    @Override
    public Optional<User> getById(int t) {
        TypedQuery<User> query = session.createQuery("FROM User WHERE id= :id",User.class);
        query.setParameter("id",t);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void delete(User o) {
        Transaction transaction = transactionManager.beginTransaction();
        session.delete(o);
        transaction.commit();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        TypedQuery<User> query = session.createQuery("FROM User WHERE userName= :userName",User.class);
        query.setParameter("userName",username);
        return Optional.ofNullable(query.getSingleResult());
    }
}
