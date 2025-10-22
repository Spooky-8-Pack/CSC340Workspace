package com.example.spartanthrift.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //find customers by address
    List<Customer> findByAddress(String address);

    //find if a customer is registered under an email
    boolean existsByEmail(String email);

    //find a customer by email
    Optional<Customer> findbyEmail(String email);

} 
