package com.revature.GroupDP2.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;


@Service
public class StorageManager implements Lifecycle {

<<<<<<< HEAD
    private boolean isRunning = false;
=======
    private boolean running = false;
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
    Configuration config;
    private SessionFactory sessionFactory;
    private Session session;

    public StorageManager() {
        config = new Configuration();
    }

    public void addAnnotatedClass(Class ... c) {

        for (Class currentClass :  c) {
            config.addAnnotatedClass(currentClass);
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public void start() {

        this.sessionFactory = config.buildSessionFactory();

        this.session = sessionFactory.openSession();

<<<<<<< HEAD
        isRunning = true;
=======
        running = true;
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d

    }

    @Override
    public void stop() {
<<<<<<< HEAD
        isRunning = false;
=======
        running = false;
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
        session.close();
    }

    @Override
    public boolean isRunning() {
<<<<<<< HEAD
        return isRunning;
    }
}
=======
        return running;
    }
}
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
