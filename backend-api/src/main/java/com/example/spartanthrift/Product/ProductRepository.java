package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spartanthrift.Shop.Shop;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByShopAndAvailable(Shop shop, boolean available);
    List<Product> findByAvailable(boolean available);
    List<Product> findByShop(Shop shop);

    // Get the latest 6 products (Featured products)
    List<Product> findTop6ByOrderByCreatedAtDesc();

    // Get products by category
    List<Product> findByCategory(@Param("category") Product.ProductCategory category);

}