package com.example.spartanthrift.Shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops/statistics")
public class ShopStatisticsController {
    private final ShopStatisticsService shopStatisticsService;

    public ShopStatisticsController (ShopStatisticsService shopStatisticsService) {
        this.shopStatisticsService = shopStatisticsService;
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<ShopStatistics> getShopStatistics(@PathVariable Long sellerId) {
        return ResponseEntity.ok(shopStatisticsService.getShopStatistics(sellerId));
    }
}
