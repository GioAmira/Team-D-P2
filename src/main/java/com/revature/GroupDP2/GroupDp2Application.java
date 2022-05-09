package com.revature.GroupDP2;


import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.util.TransactionManager;
import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GroupDp2Application {


	public static void main(String[] args) {
		SpringApplication.run(GroupDp2Application.class, args);


		StorageManager storageManager = new StorageManager();
		storageManager.addAnnotatedClass(Product.class);

		Session session = storageManager.initializeDatasource();

		TransactionManager transactionManager = new TransactionManager(session);

		Transaction tx = transactionManager.beginTransaction();
		Product newProduct = new Product(1L, "Pop", "Micheal Greatest Hits", "9.99", 1L);

		session.save(newProduct);
		transactionManager.commitTransaction(tx);

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Cart.class);
		//Add your class to configuration.addAnnotatedClass here

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
    
		transaction.commit();


	}
}

