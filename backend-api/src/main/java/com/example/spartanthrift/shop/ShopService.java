package com.example.spartanthrift.shop;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.spartanthrift.seller.Seller;
import com.example.spartanthrift.seller.SellerRepository;

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
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
        String newName = shopDetails.getShopName();

        if(newName != null && !shop.getShopName().equals(shopDetails.getShopName()) && shopRepository.existsByShopName(shopDetails.getShopName())) {
            throw new IllegalStateException("Shop name already exists");
        }

        shop.setShopName(shopDetails.getShopName());
        shop.setDescription(shopDetails.getDescription());
        shop.setLocation(shopDetails.getLocation());

        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
        Seller seller = shop.getSeller();

        if(seller != null) {
            seller.setShop(null);
        }
        shopRepository.delete(shop);
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

}
