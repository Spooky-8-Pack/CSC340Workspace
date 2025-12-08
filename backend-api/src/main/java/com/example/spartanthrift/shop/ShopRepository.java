package com.example.spartanthrift.shop;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spartanthrift.seller.Seller;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findBySeller(Seller seller);
    Optional<Shop> findBySellerId(Long id);
    
    boolean existsByShopName(String shopName);
}
