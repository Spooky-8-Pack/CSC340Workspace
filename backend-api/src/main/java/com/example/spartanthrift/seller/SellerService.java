package com.example.spartanthrift.Seller;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller createSeller(Seller seller) {
        if (sellerRepository.existsByEmail(seller.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        return sellerRepository.save(seller);
    }

     public Seller updateSeller(Long id, Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Seller not found"));

        seller.setName(sellerDetails.getName());
        if (!seller.getEmail().equals(sellerDetails.getEmail()) &&
            sellerRepository.existsByEmail(sellerDetails.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        seller.setEmail(sellerDetails.getEmail());
        seller.setPassword(sellerDetails.getPassword());

        return sellerRepository.save(seller);
    }
    
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }

    public Seller getSellerByEmail(String email) {
        return sellerRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }
}
