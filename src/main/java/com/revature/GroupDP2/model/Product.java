package com.revature.GroupDP2.model;


import javax.persistence.*;

//Product class - corresponds to GroupDP2_product in db

@Entity
@Table(name="product",schema = "groupd")
public class Product {


    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;


    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;


    public Product(Long productId, String productName, String description, String price, Long categoryId) {
        this.product_id = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;

    }
    public Product() {

    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getCategory_Id() {
        return categoryId;
    }

    public void setCategoryId(Long category_Id) {
        this.categoryId = category_Id;
    }


}


