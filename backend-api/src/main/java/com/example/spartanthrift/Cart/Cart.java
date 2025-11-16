package com.example.spartanthrift.Cart;

import java.time.LocalDateTime;

import com.example.spartanthrift.Customer.Customer;
import com.example.spartanthrift.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties("cart")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"cart", "reviews"})
    private Product product;

    private LocalDateTime dateAdded;

    private boolean inCart = true;

    //blank constructor
    public Cart(){}

    //constructor given ID
    public Cart(Long id, Customer customer, Product product, LocalDateTime dateAdded, boolean inCart){
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.dateAdded = dateAdded;
        this.inCart = inCart;
    }

    //constructor given no ID
    public Cart(Customer customer, Product product, LocalDateTime dateAdded, boolean inCart){
        this.customer = customer;
        this.product = product;
        this.dateAdded = dateAdded;
        this.inCart = inCart;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

        public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }
}
