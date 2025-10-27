package com.example.spartanthrift.Customer;

import java.util.ArrayList;
import java.util.List;

import com.example.spartanthrift.Cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    //all fields for a customer should be filled as we want a customer to have every attribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private List<Cart> cart = new ArrayList<>();


    //blank constructor
    public Customer(){

    }

    //constructor with args
    public Customer(Long customerId, String name, String password, String address, String email){
        this.customerId = customerId;
        this.address = address;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

       public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
