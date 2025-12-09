package com.example.spartanthrift.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.Customer.CustomerService;
import com.example.spartanthrift.Product.Product;
import com.example.spartanthrift.Product.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;

    private final ProductRepository productRepository;

    public CartController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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

    @PostMapping("/cart/{id}/cancel")
    public void removeFromCart(@PathVariable Long id){
        cartService.removeCart(id);
    }

    @GetMapping("/cart/customer/{customerId}")
    public Object getCustomerCart(@PathVariable Long customerId){
        return cartService.getCartByCustomer(customerService.getCustomerById(customerId));
    }

    @GetMapping("/cart/product/{productId}")
    public Object getCartItems(@PathVariable Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return cartService.getCartByProduct(product);
    }
    
    //get by seller goes here
}
