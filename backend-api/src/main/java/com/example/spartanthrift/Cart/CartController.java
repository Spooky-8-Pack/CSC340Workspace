package com.example.spartanthrift.Cart;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.Customer.CustomerService;
import com.example.spartanthrift.Product.ProductService;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    private ProductService productService;
    private CustomerService customerService;
    //seller service goes here

    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart){
        return ResponseEntity.ok(cartService.updateCart(id, cart));
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id){
        cartService.removeCart(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCustomerCart(@PathVariable Long customerId){
        return ResponseEntity.ok(cartService.getCartByCustomer(customerService.getCustomerById(customerId)));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable Long productId){
        return ResponseEntity.ok(cartService.getCartByProduct(productService.getProductById(productId)));
    }
    
    //get by seller goes here
}
