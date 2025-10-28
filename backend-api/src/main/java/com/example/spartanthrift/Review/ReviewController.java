package com.example.spartanthrift.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.Customer.CustomerService;
import com.example.spartanthrift.Product.Product;
import com.example.spartanthrift.Product.ProductService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private ProductService productService;
    private  CustomerService customerService;
    //seller service goes here

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    //add seller response goes here

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductReviews(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.getReviewsByProduct(productService.getProductById(productId)));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Review>> getCustomerReviews(@PathVariable Long customerId) {
        return ResponseEntity.ok(reviewService.getReviewsByCustomer(customerService.getCustomerById(customerId)));
    }

    //get by seller goes here

    @GetMapping("/product/{productId}/ratings")
    public ResponseEntity<Map<String, Double>> getProductRatings(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        Map<String, Double> ratings = new HashMap<>();
        ratings.put("rating", reviewService.getAverageRating(product));
        return ResponseEntity.ok(ratings);
    }

}
