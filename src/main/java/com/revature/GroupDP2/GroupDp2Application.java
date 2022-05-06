package com.revature.GroupDP2;


import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroupDp2Application {


	public static void main(String[] args) {
		SpringApplication.run(GroupDp2Application.class, args);

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Cart.class);
		//Add your class to configuration.addAnnotatedClass here

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
    
		transaction.commit();

	}

}
