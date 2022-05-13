package com.revature.GroupDP2.services;

import com.revature.GroupDP2.controllers.ProductController;
import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductService {


    private ProductRepository productRepository;
    public List<Product> getAllProduct;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> getAllProduct() {
        return null;
    }

    public void createProduct (Product p) {
        productRepository.create(p);
    }
    public void updateProduct(Product p) {
         productRepository.update(p);
    }
    public void deleteProduct (Object product) {
         productRepository.delete((Product) product);
    }

    public static Object getProductById(Integer id) {
        return null;
    }


    public String getProductByProductname(String productnameorId) {
        return null;
    }

    public AuthDto authenticateProduct(AuthDto authDto) {
        return null;
    }

    public Product update(Product product) {
        return null;
    }

    public Product delete(Product product) {
        return null;
    }


}

