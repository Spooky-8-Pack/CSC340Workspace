package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    
    //get customer profile - view profile
    @GetMapping("/customers/{id}")
    public Object getCustomerById(@PathVariable Long id, Model model) {
        //return customerService.getCustomerById(id);
        model.addAttribute("customer", customerService.getCustomerById(id));
        model.addAttribute("title", "Customer ID: ");
        return "customer-profile";
    }
    
    //get customer cart - view cart
    @GetMapping("/customers/{id}/cart")
    public Object getCustomerCart(@PathVariable Long id){
        return "customer-cart";
    }

    //create a customer - sign up
    @PostMapping("/customer/sign up")
    public Object createCustomer(Customer customer) {
        //return customerService.createCustomer(customer);
        Customer newCustomer = customerService.createCustomer(customer);
        return "redirect:/home";
    }

    //update customer - update a profile
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    //delete profile
    @GetMapping("/customers/{id}")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/home";
    }

    //end points im not sure i'll need
    @GetMapping("/customers")
    public Object getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/search/address")
    public Object searchByAddress(@RequestParam String key) {
        return customerService.searchByAddress(key);
    }
}