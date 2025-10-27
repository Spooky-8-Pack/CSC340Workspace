package com.example.spartanthrift.shop;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop createShop(Shop shop) {
        if(shopRepository.existsByShopName(shop.getShopName())) {
            throw new IllegalStateException("Shop name already exists");
        }
        return shopRepository.save(shop);
    }

    public Shop updateShop(Long id, Shop shopDetails) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Shop not found"));

        if(!shop.getShopName().equals(shopDetails.getShopName()) && shopRepository.existsByShopName(shopDetials.getShopName())) {
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
