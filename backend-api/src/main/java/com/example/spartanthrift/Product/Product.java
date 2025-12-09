package com.example.spartanthrift.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.spartanthrift.Shop.Shop;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal price;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_path")
    @Size(max = 10)
    private List<String> imagePaths; // User may add up to 10 images per product

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    private boolean available = true;

    @Column
    private LocalDate soldDate;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    //review mapping here

    //blank constructor
    public Product(){}

    //constructor given ID
    public Product(Long id, String name, String description, BigDecimal price, boolean available, 
        Shop shop, List<String> imagePaths, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.shop = shop;
        this.imagePaths = imagePaths;
        this.category = category;
    }

    //constructor given no ID
    public Product(String name, String description, BigDecimal price, boolean available, Shop shop, List<String> imagePaths) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.shop = shop;
        this.imagePaths = imagePaths;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    // Set of constant clothing categories
    public enum ProductCategory {
        TOPS,
        BOTTOMS,
        DRESSES,
        SHOES,
        ACCESSORIES,
        HEADWEAR
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    @PrePersist
    public void setDateAdded() {
        this.dateAdded = LocalDateTime.now();
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setId(Long id) {
        this.id = id;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

      public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
}
