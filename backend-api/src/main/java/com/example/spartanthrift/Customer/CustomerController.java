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
    public Object getCustomerProfile(@PathVariable Long id, String email, Model model) {
        Customer customer = customerService.findByEmail(email);
        Long customerId = customer.getCustomerId();
        model.addAttribute("customer", customerId);
        model.addAttribute("title", "Customer: " + customerId);
        return "customer-profile";
    }

    //get customer signin form
    @GetMapping("/customers/signin")
    public Object showSigninForm(Model model){
        return "customer-sign-in";
    }

    //get customer cart - view cart
    @GetMapping("/customers/{id}/cart")
    public Object getCustomerCart(@PathVariable Long id){
        return "customer-cart";
    }

    //get customer signup form
    @GetMapping("/customers/signup")
    public Object showSignupForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("title", "Sign Up");
        return "customer-sign-up";
    }
      
    //create a customer - sign up
    @PostMapping("/customers/signup")
    public Object createCustomer(Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/home";
    }

    //get customer update form
    @GetMapping("/customers/{id}/update")
    public String showUpdateForm(@PathVariable Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-update";
    }

    //update customer - update a profile
    @PostMapping("/customers/{id}/update")
    public String updateCustomer(@PathVariable Long id, Customer customerDetails) {
        customerService.updateCustomer(id, customerDetails);
        return "redirect:/customers/" + id;
    }

    //delete profile
    @GetMapping("/customers/{id}/delete")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/home";
    }
}