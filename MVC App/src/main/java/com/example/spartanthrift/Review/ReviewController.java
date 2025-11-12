package com.example.spartanthrift.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.Customer.CustomerService;
import com.example.spartanthrift.Product.ProductService;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private  CustomerService customerService;
    //seller service goes here

    @PostMapping("/reviews")
    public Object createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    //add seller response goes here

     @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/reviews/product/{productId}")
    public Object getProductReviews(@PathVariable Long productId) {
        return reviewService.getReviewsByProduct(productService.getProductById(productId));
    }

    @GetMapping("/reviews/customer/{customerId}")
    public Object getCustomerReviews(@PathVariable Long customerId) {
        return reviewService.getReviewsByCustomer(customerService.getCustomerById(customerId));
    }

    //get by seller goes here

}
