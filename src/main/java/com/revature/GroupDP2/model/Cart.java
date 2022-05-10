package com.revature.GroupDP2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cart", schema="groupd")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="cart_items")
    @OneToMany(mappedBy = "cart", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private List<Product> cartItems = new ArrayList<>();

    @Column(name="order_initialized")
    private Timestamp cartInitialized;

    public Cart(Integer userId) {
        this.userId = userId;
    }

    public Cart() {

    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public List<Product> getCartItems() {return cartItems;}

    public void setCartItems(List<Product> cartItems) {this.cartItems = cartItems;}

    public Timestamp getOrderInitialized() {return cartInitialized;}

    public void setOrderInitialized(Timestamp cartInitialized) {this.cartInitialized = cartInitialized;}

    public void addCartItem(Product product){
        cartItems.add(product);
    }
    public void deleteCartItem(Product product){
        cartItems.remove(product);
    }
}
