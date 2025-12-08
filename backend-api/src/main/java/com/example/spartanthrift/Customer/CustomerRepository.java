package com.example.spartanthrift.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //find customer by email
    Customer findByEmail(String email);

    //find if a customer is registered under an email
    boolean existsByEmail(String email);
} 
