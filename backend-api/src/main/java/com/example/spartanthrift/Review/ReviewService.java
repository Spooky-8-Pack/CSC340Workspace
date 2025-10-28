package com.example.spartanthrift.Review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.example.spartanthrift.Customer.Customer;
import com.example.spartanthrift.Product.Product;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    //get average rating
    public double getAverageRating(Product product) {
        List<Review> reviews = reviewRepository.findByProduct(product);
        OptionalDouble average = reviews.stream()
                .mapToDouble(review -> review.getRating() != null ? review.getRating() : 0.0)
                .average();
        return average.orElse(0.0);
    }

    //create review
    public Review createReview(Review review) {
        double rating = review.getRating() != null ? review.getRating() : 0;

        review.setRating(rating);
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    //add seller response goes here

    //delete review
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new EntityNotFoundException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    //get reviews by product
    public Object getReviewsByProduct(Product product) {
        return reviewRepository.findByProduct(product);
    }

      public Object getReviewsByCustomer(Customer customer) {
        return reviewRepository.findByCustomer(customer);
    }

    //get by seller goes here
}
