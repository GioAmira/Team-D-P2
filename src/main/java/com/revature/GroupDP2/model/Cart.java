package com.revature.GroupDP2.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="cart", schema="groupd")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="product_id")
    private Integer productId;

    @Column
    private Integer quantity;

    @Column
    private Float price;

    @Column(name="order_initialized")
    private Timestamp orderInitialized;


    public Cart(Long userId, Integer productId, Integer quantity, Float price, Timestamp orderInitialized) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.orderInitialized = orderInitialized;
    }

    public Cart() {}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public Integer getProductId() {return productId;}

    public void setProductId(Integer productId) {this.productId = productId;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Float getPrice() {return price;}

    public void setPrice(Float price) {this.price = price;}

    public Timestamp getOrderInitialized() {return orderInitialized;}

    public void setOrderInitialized(Timestamp orderInitialized) {this.orderInitialized = orderInitialized;}
}
