package com.example.spartanthrift.shop;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spartanthrift.seller.Seller;
import com.example.spartanthrift.seller.SellerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopService {
    private final ShopRepository shopRepository;
    private final SellerRepository sellerRepository;  
      
    public ShopService(ShopRepository shopRepository, SellerRepository sellerRepository) {
        this.shopRepository = shopRepository;
        this.sellerRepository = sellerRepository;
    }

    public Shop createShop(Long sellerId, String shopName, String description, String location) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("Seller not found"));
        
        if(shopRepository.existsByShopName(shopName)) {
            throw new IllegalStateException("Shop name already exists");
        }

        Shop shop = new Shop(seller, shopName, description, location);
        
        return shopRepository.save(shop);
    }

    public Shop updateShop(Long id, Shop shopDetails) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Shop not found"));

        if(!shop.getShopName().equals(shopDetails.getShopName()) && shopRepository.existsByShopName(shopDetails.getShopName())) {
            throw new IllegalStateException("Shop name already exists");
        }

        shop.setShopName(shopDetails.getShopName());
        shop.setDescription(shopDetails.getDescription());
        shop.setLocation(shopDetails.getLocation());

        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        if(!shopRepository.existsById(id)) {
            throw new EntityNotFoundException("Shop not found");
        }
        shopRepository.deleteById(id);
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Shop not found"));
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

}
