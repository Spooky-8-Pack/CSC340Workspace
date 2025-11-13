package com.example.spartanthrift.shop;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.getShopById(id));
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestParam Long sellerId, @Valid @RequestBody Shop shop) {
        Shop newShop = shopService.createShop(sellerId, shop.getShopName(), shop.getDescription(), shop.getLocation());

        return ResponseEntity.status(HttpStatus.CREATED).body(newShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @Valid @RequestBody Shop shopDetails) {
        return ResponseEntity.ok(shopService.updateShop(id, shopDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.ok().build();
    }

}
