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

    @OneToOne(mappedBy = "cart")
    private User user;

    @Column(name = "cartItems")
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    @JoinTable(
            joinColumns = { @JoinColumn(name = "cartItems") },
            inverseJoinColumns = { @JoinColumn(name = "productCart") }
    )
    private List<Product> cartItems = new ArrayList<>();


    public Cart(User user) {this.user = user;}

    public Cart() {}

    public void addCartItem(Product product){
        cartItems.add(product);
    }
    public void deleteCartItem(Product product){
        cartItems.remove(product);
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public User getUser() {return this.user;}

    public void setUser(User user) {this.user = user;}

    public List<Product> getCartItems() {return cartItems;}

    public void setCartItems(List<Product> cartItems) {this.cartItems = cartItems;}

}
