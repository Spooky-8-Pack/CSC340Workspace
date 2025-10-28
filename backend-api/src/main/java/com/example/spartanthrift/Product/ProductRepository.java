package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //find by seller goes here

    //find by available
    List<Product> findByAvailable(boolean available);
}
