package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    public Object getAllCustomers(){
        return customerRepository.findAll();
    }

    //get a customer by id  
    public Object getCustomerById(@PathVariable long customerId){
        return customerRepository.findById(customerId).orElse(null);
    }

    //get customer by name
    public Object getCustomerByName(String name){
        return customerRepository.getCustomersByName(name);
    }

    //get customer by email
    public Object getCustomerByEmail(String email){
        return customerRepository.getCustomersByEmail(email);
    }

    //update customer
    public Customer updateCustomer(Long customerId, Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }    
}
