package com.example.spartanthrift.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spartanthrift.Customer.Customer;
import com.example.spartanthrift.Product.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCustomer(Customer customer);
    List<Cart> findByProduct(Product product);
    //find by seller goes here

}
