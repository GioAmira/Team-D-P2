
package com.revature.GroupDP2.services;


import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    public Product getProductByProductName(String productname) {
        return productRepository.getByProductName(productname);
    }

    public Optional<Product> getProductById(Integer id) {
        return (Optional<Product>) productRepository.getById(id);
    }

    public Optional<Product> getCategoryById(Integer id) {
        ProductRepository categoryRepository = null;
        return (Optional<Product>) categoryRepository.getById(id);

    }

   /* public Optional<User> getUserByUsername(String username) {
        IUserRepository userRepository = null;
        return userRepository.getByUsername(username);
    }
*/
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public Product authenticateUser(AuthDto authDto) throws Exception {
        Product product = productRepository.getByProductName(authDto.getProductName());
        if (product != null && product.getProduct_id().equals(authDto.getProductId())) {
            return product;
        } else {
            throw new Exception("Unauthorized!");
            //TODO: Make this into a custom exception
        }
    }

        public Product update(Product product) {
            return productRepository.update(product);
        }
}