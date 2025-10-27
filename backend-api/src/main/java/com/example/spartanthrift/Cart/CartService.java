package com.example.spartanthrift.Cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spartanthrift.Customer.Customer;
import com.example.spartanthrift.Product.Product;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartService {
    private CartRepository cartRepository;

    //add item to cart
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    //update cart item
    public Cart updateCart(Long id, Cart cartDetails){
        Cart cart = cartRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cart Item Not Found"));
        cart.setDateAdded(cartDetails.getDateAdded());
        cart.setInCart(cartDetails.isInCart());

        return cartRepository.save(cart);
    }

    //remove cart item
    public void removeCart(Long id){
        Cart cart = cartRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cart Item Not Found"));
        cart.setInCart(false);
        cartRepository.save(cart);
    }

    //find by customer
    public List<Cart> getCartByCustomer(Customer customer){
        return cartRepository.findByCustomer(customer);
    }
    
    //find by product
    public List<Cart> getCartByProduct(Product product){
        return cartRepository.findByProduct(product);
    }

    //get by seller goes here
}
