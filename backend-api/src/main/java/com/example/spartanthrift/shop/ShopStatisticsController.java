// package com.example.spartanthrift.shop;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/shops/statistics")
// @RequiredArgsConstructor
// public class ShopStatisticsController {
//     private final ShopStatisticsService shopStatisticsService;

//     @GetMapping("/{sellerId}")
//     public ResponseEntity<ShopStatistics> getShopStatistics(@PathVariable Long sellerId) {
//         return ResponseEntity.ok(shopStatisticsService.getShopStatistics(sellerId));
//     }
// }
