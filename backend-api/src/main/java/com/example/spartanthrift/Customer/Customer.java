package com.example.spartanthrift.Customer;

import java.util.ArrayList;
import java.util.List;

import com.example.spartanthrift.Cart.Cart;
import com.example.spartanthrift.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends User{

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private List<Cart> cart = new ArrayList<>();
    
    // Blank constructor
    public Customer(){

    }

    // Constructor with args
    public Customer(String address, List<Cart> cart){
        this.address = address;
        this.cart = cart;
    }

    // Getters and setters
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
