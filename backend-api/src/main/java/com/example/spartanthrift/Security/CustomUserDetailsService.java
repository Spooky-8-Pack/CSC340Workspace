package com.example.spartanthrift.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spartanthrift.Customer.CustomerRepository;
import com.example.spartanthrift.Seller.SellerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;

    public CustomUserDetailsService(SellerRepository sellerRepository, CustomerRepository customerRepository) {
        this.sellerRepository = sellerRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Try to find seller first
        var seller = sellerRepository.findByEmail(email);
        if (seller.isPresent()) {
            return seller.get();
        }
        
        // If not a seller, try to find customer
        var customer = customerRepository.findByEmail(email);
        if (customer != null) {
            return customer;
        }
        
        // If neither seller nor customer found, throw exception
        throw new UsernameNotFoundException("Account not found");
    }




}
