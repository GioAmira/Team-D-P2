package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICartRepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class CartRepository implements ICartRepository {

    private TransactionManager transactionManager;
    private Session session;

    public CartRepository(TransactionManager transactionManager,Session session) {
        this.transactionManager = transactionManager;
        this.session =session;
    }

    @Override
    public void create(Cart c) {
        Transaction transaction = transactionManager.beginTransaction();
        session.save(c);
        transaction.commit();
    }

    @Override
    public void update(Cart c) {
        Transaction transaction = transactionManager.beginTransaction();
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
        Transaction transaction = transactionManager.beginTransaction();
        session.delete(c);
        transaction.commit();
    }

}
