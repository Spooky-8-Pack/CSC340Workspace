package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //get all customers
    public Object getAllCustomers(){
        return customerRepository.findAll();
    }

    //get a customer by id  
     public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
     }

     //search customers by address
     public Customer findByEmail(String email){
        return customerRepository.findByEmail(email);
     }

    //add customer
    public Customer createCustomer(Customer customer){
        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalStateException("Email already registered");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }
    
    //update customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        // Only update password if it was provided
        if (customerDetails.getPassword() != null && !customerDetails.getPassword().isEmpty()) {
            customer.setPassword(passwordEncoder.encode(customerDetails.getPassword()));
        }
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
       if (!customerRepository.existsById(id)){
        throw new EntityNotFoundException("Customer not found");
       }
       customerRepository.deleteById(id);
    }
    
    //change customer password
    public Customer changePassword(Long id, String currentPassword, String newPassword, String confirmPassword) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        
        // Verify passwords match
        if (!newPassword.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        
        // Update password
        customer.setPassword(passwordEncoder.encode(newPassword));
        return customerRepository.save(customer);
    }
}