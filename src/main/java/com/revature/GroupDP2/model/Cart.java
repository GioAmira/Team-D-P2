package com.revature.GroupDP2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="cart", schema="groupd")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="cart_items")
    @OneToMany
    private List<Product> cartItems;

    @Column(name="order_initialized")
    private Timestamp orderInitialized;

    public Cart(Integer userId, List<Product> cartItems, Timestamp orderInitialized) {
        this.userId = userId;
        this.cartItems = cartItems;
        this.orderInitialized = orderInitialized;
    }

    public Cart() {}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

    public List<Product> getCartItems() {return cartItems;}

    public void setCartItems(List<Product> cartItems) {this.cartItems = cartItems;}

    public Timestamp getOrderInitialized() {return orderInitialized;}

    public void setOrderInitialized(Timestamp orderInitialized) {this.orderInitialized = orderInitialized;}
}
