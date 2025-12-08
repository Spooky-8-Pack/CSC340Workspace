package com.example.spartanthrift.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.spartanthrift.seller.Seller;
import com.example.spartanthrift.seller.SellerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SellerRepository sellerRepository;

    public CustomUserDetailsService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return sellerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Account not found"));
    }




}
