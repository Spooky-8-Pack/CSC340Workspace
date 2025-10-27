package com.example.spartanthrift.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spartanthrift.Customer.Customer;
import com.example.spartanthrift.Product.Product;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    List<Review> findByCustomer(Customer customer);
    //find by seller goes here
}
