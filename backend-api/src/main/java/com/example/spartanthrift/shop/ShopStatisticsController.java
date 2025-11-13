package com.example.spartanthrift.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops/statistics")
public class ShopStatisticsController {
    private final ShopService shopStatisticsService;

    public ShopStatisticsController(ShopService shopStatisticsService) {
        this.shopStatisticsService = shopStatisticsService;
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<ShopStatistics> getShopStatistics(@PathVariable Long sellerId) {
        return ResponseEntity.ok(shopStatisticsService.getShopStatistics(sellerId));
    }
}
