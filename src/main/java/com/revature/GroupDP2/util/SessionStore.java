package com.revature.GroupDP2.util;

import com.revature.GroupDP2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


public class SessionStore {
    private Session session;

    public SessionStore() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Payment.class);
        configuration.addAnnotatedClass(Cart.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Category.class);
        //Add your class to configuration.addAnnotatedClass here
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }
}
