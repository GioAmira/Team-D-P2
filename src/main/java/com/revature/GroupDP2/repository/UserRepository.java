package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IUserRepository;
import com.revature.GroupDP2.util.SessionStore;
import com.revature.GroupDP2.util.TransactionManager;
import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository implements IUserRepository {
    private final Session session;
    @Autowired
    public UserRepository(SessionStore sessionstore) {
        this.session =sessionstore.getSession();
    }

    @Override
    public void create(User o) {
        Transaction t=session.beginTransaction();
        session.save(o);
        t.commit();
    }

    @Override
    public void update(User o) {
        Transaction t=session.beginTransaction();
        session.update(o);
        t.commit();
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
        Transaction t=session.beginTransaction();
        session.delete(o);
        t.commit();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        TypedQuery<User> query = session.createQuery("FROM User WHERE userName= :userName",User.class);
        query.setParameter("userName",username);
        return Optional.ofNullable(query.getSingleResult());
    }
}
