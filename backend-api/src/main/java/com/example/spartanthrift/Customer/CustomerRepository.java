package com.example.spartanthrift.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //find customers by address
    List<Customer> findByAddress(String address);

    //find if a customer is registered under an email
    boolean existsByEmail(String email);
} 
