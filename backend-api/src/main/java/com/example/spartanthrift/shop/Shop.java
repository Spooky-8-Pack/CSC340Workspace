package com.example.spartanthrift.shop;

import java.util.ArrayList;
import java.util.List;

import com.example.spartanthrift.Product.Product;
import com.example.spartanthrift.Seller.Seller;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
// import com.example.spartanthrift.product.product; // Import for after merging to access the product class


// import java.util.List;
// import java.util.ArrayList;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonBackReference
    private Seller seller;

    @NotBlank 
    @Column(nullable = false)
    private String shopName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank
    private String location;

    private String shopImagePath;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();


    public Shop() {
    }

    public Shop(Seller seller, String shopName, String description, String location, String shopImagePath, List<Product> products) {
        this.seller = seller; 
        this.shopName = shopName;
        this.description = description;
        this.location = location;
        this.shopImagePath = shopImagePath;
        this.products = products;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public String getShopImagePath() {
        return shopImagePath;
    }

    public void setShopImagePath(String shopImagePath) {
        this.shopImagePath = shopImagePath;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
