package com.example.spartanthrift.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    

    //custom query to search for customers by email
    @Query(value = "select * from customers s where s.email like %?1%", nativeQuery = true)
    List<Customer> getCustomersByEmail(String email);

    //custom query to search for customers by name
    @Query(value = "select * from customers s where s.name like %?1%", nativeQuery = true)
    List<Customer> getCustomersByName(String name);


    
} 
