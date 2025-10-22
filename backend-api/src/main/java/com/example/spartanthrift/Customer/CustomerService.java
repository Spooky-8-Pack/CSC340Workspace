package com.example.spartanthrift.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //get a customer by id  
     public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
     }

     //search customers by address
     public List<Customer> searchByAddress(String address){
        return customerRepository.findByAddress(address);
     }

    //add customer
    public Customer createCustomer(Customer customer){
        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalStateException("Email already registered");
        }
        return customerRepository.save(customer);
    }
    
    //update customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setName(customerDetails.getName());
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