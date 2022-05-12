package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICartRepository;
import com.revature.GroupDP2.model.Cart;
<<<<<<< HEAD
import com.revature.GroupDP2.model.Product;
=======
import com.revature.GroupDP2.util.StorageManager;
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;
@Repository
public class CartRepository implements ICartRepository, Lifecycle {

    private StorageManager storageManager;
    private Session session;
    private boolean running=false;
    @Autowired
    public CartRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public void create(Cart c) {
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
    }

    @Override
    public void update(Cart c) {
        Transaction transaction = session.beginTransaction();
        session.update(c);
        transaction.commit();
    }

    @Override
    public Optional<Product> getById(int t) {
        TypedQuery<Cart> query = session.createQuery("FROM Cart WHERE id = :id",Cart.class);
        query.setParameter("id",t);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void delete(Cart c) {
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
    }

    @Override
    public void start() {
        this.session =storageManager.getSession();
        running=true;
    }

    @Override
    public void stop() {
    running=false;
    session.close();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
