package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductService {
    @Service
    public class ProductService {
        com.revature.GroupDP2.repository.ProductRepository ProductRepository;
        @Autowired
        public ProductService(ProductRepository productRepository){
            this.productRepository = productRepository;
        }

        public void create(Product product){

            productRepository.create(product);
        }
    }
}
