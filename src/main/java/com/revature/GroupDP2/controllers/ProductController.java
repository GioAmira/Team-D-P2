package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;

import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path ="/product")
public class ProductController {
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    //Get all products
    @GetMapping("/{productorId")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        return productService.getAllProduct;
    }

        //get product by productname
        @GetMapping("/{productnameorId}")
        @ResponseStatus(HttpStatus.OK)
        public Product getProduct (@PathVariable String productnameorId, @RequestHeader("mode") String mode) throws
        Exception {
        switch (mode) {
            case "productname":
                return productService.getProductByProductname(productnameorId);
            case "id":
                return productService.getProductById(Integer.parseInt(productnameorId));
            default:
                throw new Exception("That's not a valid mode");
                //TODO: Make this better
        }
    }

        //post a new product - auto generate the ID
        @PostMapping()
        @ResponseStatus(HttpStatus.OK)
        public Product persistNewProduct (@RequestBody Product newProduct){
            Object persistNewProduct = null;
            return productService.save(persistNewProduct);
    }
        @GetMapping("/auth")
        @ResponseStatus(HttpStatus.OK)
        public Product authorizeProduct (@RequestBody AuthDto authDto) throws Exception {
        return productService.authenticateProduct(authDto);
        //TODO: ResponseEntity<User> use this object to send back a different response for unauthorized
    }

        //put (update) an existing user (based on id)
        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Product updateProduct (@RequestBody Product product){
        return productService.update(product);
    }
        @DeleteMapping
        @ResponseStatus(HttpStatus.OK)
        public Product deleteProduct (@RequestBody Product product){
        return productService.delete(product);
    }

    private class ProductService {
        public List<Product> getAllProduct;

        public Product getProductByProductname(String productnameorId) {
            return null;
        }

        public Product getProductById(int parseInt) {
            return null;
        }

        public Product save(Object persistNewProduct) {
            return null;
        }

        public Product update(Product product) {
            return null;
        }

        public Product delete(Product product) {
            return null;
        }

        public Product authenticateProduct(AuthDto authDto) {
            return null;
        }
    }
}



