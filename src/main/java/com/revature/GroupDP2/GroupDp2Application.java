package com.revature.GroupDP2;



import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.*;
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
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(Category.class);
		//Add your class to configuration.addAnnotatedClass here


		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//Add your transactions in between
		Category rock = new Category("Rock");
		rock.addProduct(new Product(rock,"Dark side of the moon", "Descr",12.5));
		session.save(rock);
		User user = new User("Username","password",false,"first","last","email","phone","street","city","state","zipcode");
		session.save(user);
		Product product = new Product(rock,"popAlbum","descr",10.5);
		session.save(product);
		Cart cart = new Cart(user);
		cart.addCartItem(product);
		session.save(cart);


		//add your code here

		transaction.commit();

		/*
			StorageManager storageManager = new StorageManager();
			storageManager.addAnnotatedClass(Category.class);
			Session session = storageManager.initializeDatasource();
			TransactionManager transactionManager = new TransactionManager(session);
			CategoryRepository categoryRepository = new CategoryRepository(transactionManager,session);

			Category newCategory = new Category("Rock");
			categoryRepository.create(newCategory);
			//categoryRepository.delete(newCategory);
			//System.out.println(categoryRepository.getById(1));
			System.out.println(categoryRepository.getByCategoryName(newCategory));

		 */

		/*
			Category rock = new Category("Rock");
			Category pop = new Category("Pop");

			rock.addProduct(new Product(rock,"Dark side of the moon", "Descr","100"));
			rock.addProduct(new Product(pop,"The Sickness","Disturbed","150"));

			session.save(rock);
			session.save(pop);
		 */


	}
}

