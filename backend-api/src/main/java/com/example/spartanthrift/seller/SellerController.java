package com.example.spartanthrift.seller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<Seller> createSeller(@Valid @RequestBody Seller seller) {
        return ResponseEntity.ok(sellerService.createSeller(seller));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails) {
        return ResponseEntity.ok(sellerService.updateSeller(id, sellerDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable Long id) { 
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }
}
