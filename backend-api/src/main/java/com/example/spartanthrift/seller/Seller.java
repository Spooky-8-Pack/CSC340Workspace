package com.example.spartanthrift.Seller;

import com.example.spartanthrift.shop.Shop;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    private String sellerImagePath;

    public Seller() {
    }

    @OneToOne(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonBackReference
    private Shop shop;

    public Seller(Long id, String name, String email, String password, String sellerImagePath) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.sellerImagePath = sellerImagePath;
    }

    public Long getSellerId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getSellerImagePath() {
        return sellerImagePath;
    }

    public void setSellerImagePath(String sellerImagePath) {
        this.sellerImagePath = sellerImagePath;
    }
    
}
