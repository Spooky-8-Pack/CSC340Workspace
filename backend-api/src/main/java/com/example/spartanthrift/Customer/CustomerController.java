package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Object createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    //get customer profile
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers")
    public Object getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/search/address")
    public Object searchByAddress(@RequestParam String key) {
        return customerService.searchByAddress(key);
    }

    @DeleteMapping("/{id}")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return customerService.getAllCustomers();
    }
}