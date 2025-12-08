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
        Seller seller = sellerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Account not found"));

        String role = "ROLE_" + seller.getRole();

        return User.builder()
            .username(seller.getEmail())
            .password(seller.getPassword())
            .roles(role.replace("ROLE_", ""))
            .build();
    }



}
