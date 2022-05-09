/*
package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:63343/Team-D-P2/GroupDP2/Template/product.html?_ijt=cs3dr2d36774ao83jpgeoi1l4f&_ij_reload=RELOAD_ON_SAVE)", allowCredentials = "true")
@RequestMapping(path ="/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @RequestMapping(value="/create", method=RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        p = ProductService.addProduct(p);
        if (p == null) {
            return new ResponseEntity<Product>(p, HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity<Product>(p, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value="/update", method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody Product p) {
        p = ProductService.updateProduct(p);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> deleteProduct(@RequestBody Product p) {
        System.out.println(p.get());
        Product result = ProductServices.delete(p.getProduct());
        System.out.println(result);
        return new ResponseEntity<Product>(result, HttpStatus.OK);
    }

    public ProductServices getProductServices() {
        return productServices;
    }

    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    private static class ProductService {
        public static Product addProduct(Product p) {
            return null;
        }

        public static Product updateProduct(Product p) {
            return null;
        }
    }
}

 */