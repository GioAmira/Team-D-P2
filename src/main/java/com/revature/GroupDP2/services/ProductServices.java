package com.revature.GroupDP2.services;

import com.revature.GroupDP2.controllers.ProductController;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductServices")
public class ProductServices extends ProductController {

    @Autowired
    private static ProductRepository productRepository;


    public Product createProduct (Product p) {
        return productRepository.create(p);
    }

    public Product updateProduct(Product p) {
        return productRepository.update(p);
    }
    public static Product deleteProduct (Object product) {
        return productRepository.delete((Product) product);
    }


}
