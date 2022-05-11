package com.revature.GroupDP2;



import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.model.*;
import com.revature.GroupDP2.repository.CategoryRepository;
import com.revature.GroupDP2.util.SessionStore;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(scanBasePackages = "com.revature.GroupDP2")
public class GroupDp2Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GroupDp2Application.class, args);
		//this is how you get a bean, beans act as global
		StorageManager storageManager = context.getBean(StorageManager.class);
		context.start();
		storageManager.addAnnotatedClass(User.class,Cart.class,Category.class,Product.class,Payment.class);
		Session session = storageManager.getSession();






				/*
		Setup moved to SessionStore, because it had to be in a bean
		because it had to be autowired into the repositories.

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(Category.class);
		//Add your class to configuration.addAnnotatedClass here


		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
*/
		/*
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


		 */
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

