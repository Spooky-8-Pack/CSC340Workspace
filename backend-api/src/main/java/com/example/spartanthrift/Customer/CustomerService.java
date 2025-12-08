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
        customer.setPassword(passwordEncoder.encode(customerDetails.getPassword()));
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
       if (!customerRepository.existsById(id)){
        throw new EntityNotFoundException("Customer not found");
       }
       customerRepository.deleteById(id);
    }    
}