package com.example.spartanthrift.Seller;

import com.example.spartanthrift.User;
import com.example.spartanthrift.shop.Shop;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "sellers")
public class Seller extends User{
    private String sellerImagePath;

    @OneToOne(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonBackReference
    private Shop shop;

    public Seller() {
        this.setRole(Role.SELLER);
    }

    public Seller(String sellerImagePath) {
        this.sellerImagePath = sellerImagePath;
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
