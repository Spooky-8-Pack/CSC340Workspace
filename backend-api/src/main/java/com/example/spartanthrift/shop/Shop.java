package com.example.spartanthrift.shop;

import com.example.spartanthrift.seller.Seller;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
// import com.example.spartanthrift.product.product; // Import for after merging to access the product class


// import java.util.List;
// import java.util.ArrayList;

@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnoreProperties("shop")
    private Seller seller;

    @NotBlank 
    @Column(nullable = false)
    private String shopName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank
    private String location;

    public Shop(Seller seller, String shopName, String description, String location) {
        this.seller = seller; 
        this.shopName = shopName;
        this.description = description;
        this.location = location;
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

    // @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("shop")
    // private List<Product> products = new ArrayList<>();

}
