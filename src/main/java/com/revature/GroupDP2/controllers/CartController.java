package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.CartService;
import com.revature.GroupDP2.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Product> viewCart(@RequestBody Cart cart) {
        return cartService.getCartItems(cart);
    }

    @PostMapping("/add")
    public void addCart() {
        Cart cart = new Cart();

        cartService.newCart(cart);
    }

    @PutMapping("/addProduct")
    public void addProduct() {

        // Cart cart = cartService.getCartById();
    }



}



