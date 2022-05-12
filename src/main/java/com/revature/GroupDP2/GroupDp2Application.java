package com.revature.GroupDP2;

import com.revature.GroupDP2.model.Product;
<<<<<<< HEAD
import com.revature.GroupDP2.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
=======
import com.revature.GroupDP2.repository.CartRepository;
import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.model.*;

import com.revature.GroupDP2.repository.CategoryRepository;
import com.revature.GroupDP2.repository.UserRepository;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
>>>>>>> 2b3760bc5688d5d8eaa7326eee87c25b05134f3d
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(scanBasePackages = "com.revature.GroupDP2")
public class GroupDp2Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GroupDp2Application.class, args);
		//this is how you get a bean, beans act as global
		StorageManager storageManager = context.getBean(StorageManager.class);
		storageManager.addAnnotatedClass(User.class,Cart.class,Category.class,Product.class,Payment.class);

		context.start();
		Session session = storageManager.getSession();


		/*
		context.start();
		Cart cart= new Cart();
		Product product=new Product();
		context.getBean(CartRepository.class).create(cart);
		context.getBean(ProductRepository.class).create(product);
		cart.addCartItems(product);
		product.addItem(cart);
		context.getBean(CartRepository.class).update(cart);
		context.getBean(ProductRepository.class).update(product);
		Session session = storageManager.getSession();
		*/

	}
}