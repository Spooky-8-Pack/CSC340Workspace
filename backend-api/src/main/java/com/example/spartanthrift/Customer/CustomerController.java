package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.spartanthrift.Cart.*;
import com.example.spartanthrift.Product.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private CartService cartService;
    private ProductService productService;

    //profile actions
    //get customer profile - view profile
    @GetMapping("/customers/signin/{id}")
    public Object getCustomerProfile(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        model.addAttribute("title", "Customer #: " + id);
        return "customer-profile";
    }

    //get customer signin form
    @GetMapping("/customers/signin")
    public Object showSigninForm(Model model){
        return "customer-sign-in";
    }

    //find customer by email in form then redirect to profile 
    @GetMapping("/customers/signin/form")
    public Object findByEmail(String email){
        Customer customer = customerService.findByEmail(email);
        Long customerId = customer.getId();
        return "redirect:" + customerId;
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
        return "redirect:/customers/signin/" + id;
    }

    //delete profile
    @GetMapping("/customers/{id}/delete")
    public Object deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/home";
    }

    //cart actions
    //get customer cart - view cart
    @GetMapping("/customers/{id}/cart")
    public Object getCustomerCart(@PathVariable Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        Object cartItems = cartService.getCartByCustomer(customer);
        model.addAttribute("cartItems", cartItems);
        return "customer-cart";
    }

    //view product in cart
    public Object viewProductInCart(Long productId, Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-details";
    }

}