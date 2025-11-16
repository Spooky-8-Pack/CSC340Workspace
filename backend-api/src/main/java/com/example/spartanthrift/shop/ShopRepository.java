package com.example.spartanthrift.shop;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spartanthrift.Seller.Seller;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findBySeller(Seller seller);

    boolean existsByShopName(String shopName);
}
