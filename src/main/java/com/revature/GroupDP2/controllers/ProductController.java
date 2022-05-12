package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;

import com.revature.GroupDP2.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path ="/product")
public class ProductController {

    ProductServices productServices;


    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;

    }

    //Get all products
    @GetMapping("/{productorId")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        return productServices.getAllProduct;
    }

        //get product by productname
        @GetMapping("/{productnameorId}")
        @ResponseStatus(HttpStatus.OK)
        public String getProduct (@PathVariable String productnameorId, @RequestHeader("mode") String mode) throws
        Exception {
        switch (mode) {
            case "productname":
                return productServices.getProductByProductname(productnameorId);
            case "id":
                return productServices.getProductById(Integer.parseInt(productnameorId));
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
            return productServices.save(persistNewProduct);
    }
        @GetMapping("/auth")
        @ResponseStatus(HttpStatus.OK)
        public AuthDto authorizeProduct (@RequestBody AuthDto authDto) throws Exception {
        return productServices.authenticateProduct(authDto);
        //TODO: ResponseEntity<User> use this object to send back a different response for unauthorized
    }

        //put (update) an existing user (based on id)
        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Product updateProduct (@RequestBody Product product){
        return productServices.update(product);
    }
        @DeleteMapping
        @ResponseStatus(HttpStatus.OK)
        public Product deleteProduct (@RequestBody Product product){
        return productServices.delete(product);
    }

    private class ProductServices {
        public List<Product> getAllProduct;

        public String getProductByProductname(String productnameorId) {
            return productnameorId;
        }

        public String getProductById(int parseInt) {
            return null;
        }

        public Product save(Object persistNewProduct) {
            return new Product();
        }

        public Product update(Product product) {
            return product;
        }

        public Product delete(Product product) {
            return product;
        }

        public AuthDto authenticateProduct(AuthDto authDto) {
            return authDto;
        }


    }
}



