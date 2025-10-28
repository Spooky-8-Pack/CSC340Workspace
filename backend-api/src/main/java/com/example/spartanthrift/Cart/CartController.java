package com.example.spartanthrift.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.Customer.CustomerService;
import com.example.spartanthrift.Product.ProductService;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    private ProductService productService;
    private CustomerService customerService;
    //seller service goes here

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @GetMapping("/cart")
    public Object viewCart(){
        return cartService.viewCart();
    }

    @PutMapping("/cart/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart){
        return cartService.updateCart(id, cart);
    }

    @PostMapping("cart/{id}/cancel")
    public void removeFromCart(@PathVariable Long id){
        cartService.removeCart(id);
    }

    @GetMapping("/customer/{customerId}")
    public Object getCustomerCart(@PathVariable Long customerId){
        return cartService.getCartByCustomer(customerService.getCustomerById(customerId));
    }

    @GetMapping("/product/{productId}")
    public Object getCartItems(@PathVariable Long productId){
        return cartService.getCartByProduct(productService.getProductById(productId));
    }
    
    //get by seller goes here
}
