package com.revature.GroupDP2.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TransactionManager {
    private Session session;
    public TransactionManager(Session session) {
        this.session = session;
    }

    public Transaction beginTransaction(){
        return session.beginTransaction();
    }

    public void commitTransaction(Transaction tx) {
        tx.commit();

    }
}
