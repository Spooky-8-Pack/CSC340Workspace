package com.example.spartanthrift.seller;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerService {
    private final SellerRepository sellerRepository;

    public Seller createSeller(Seller seller) {
        if (sellerRepository.existsByEmail(seller.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        return sellerRepository.save(seller);
    }

    public Seller updateSeller(Long id, Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seller not found"));

        seller.setFirstName(sellerDetails.getFirstName());
        if (!seller.getEmail().equals(sellerDetails.getEmail()) && sellerRepository.existsByEmail(sellerDetails.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        seller.setEmail(sellerDetails.getEmail());

        return sellerRepository.save(seller);

    }
    
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }

    public Seller getSellerByEmail(String email) {
        return sellerRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }
}
