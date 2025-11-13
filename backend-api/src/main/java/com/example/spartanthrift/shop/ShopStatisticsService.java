package com.example.spartanthrift.shop;

import com.example.spartanthrift.seller.review.ReviewRepository;
import com.example.spartanthrift.seller.SellerService;
import com.example.spartanthrift.product.Product;
import com.example.spartanthrift.product.ProductRepository;
import com.example.spartanthrift.review.Review;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ShopStatisticsService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final SellerService sellerService;

    public ShopStatisticsService() {
    }

    public ShopStatisticsService(ShopRepository shopRepository, ProductRepository productRepository, ReviewRepository reviewRepository,
        SellerService sellerService) {
            this.shopRepository = shopRepository;
            this.productRepository = productRepository;
            this.reviewRepository = reviewRepository;
            this.sellerService = sellerService;
        }

    public ShopStatistics getShopStatistics(Long sellerId) {
        Shop shop = shopRepository.findBySeller(ShopService.getSellerById(sellerId).orElseThrow(() -> new EntityNotFoundException("Shop not found")));

        ShopStatistics stats = new ShopStatistics();

        // Calculate revenue statistics
        calculateRevenueStatistics(stats, shop);

        // Calculate product statistics
        calculateProductStatistics(stats, shop);

        // Calculate rating statistics
        calculateRatingStatistics(stats, shop);

        // Calculate review statistics
        calculateReviewStatistics(stats, shop);

        return stats;

    }

    public void calculateRevenueStatistics(ShopStatistics stats, Shop shop) {
        List<Products> allProducts = productRepository.findByProductShopSeller(shop.getSeller());

        // Total revenue
        BigDecimal total = allProducts.stream().map(sub -> sub.getProduct.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        stats.setTotalRevenue(total);

        // Monthly revenue (current month)
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);
        BigDecimal monthly = allProducts.stream()
            .filter(sub -> sub.getStartDate().isAfter(startOfMonth))
            .map(sub -> sub.getProduct.getPrice())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        stats.setMonthlyRevenue(monthly);

        // Revenue by month (last 6 months)
        Map<String, BigDecimal> revenueByMonth = new LinkedHashMap<>();
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        for (int i = 5; i >= 0; i--) {
            LocalDateTime monthStart = LocalDateTime.now().minusMonths(i).withDayOfMonth(1).withHour(0).withMinute(0);
            LocalDateTime monthEnd = monthStart.plusMonths(1);

            BigDecimal monthlyRev = allProducts.stream()
                .filter(sub -> sub.getStartDate().isAfter(monthStart) && sub.getStartDate)
        }
        stats.setRevenueByMonth(revenueByMonth);
    }

    private void calculateProductStatistics(ShopStatistics stats, Shop shop) {
        List<Product> boxes = productRepository.findByShopAndAvailable(shop, true);
        stats.setTotalProducts(products.size());
        stats.setActiveBoxes((int) products.stream().filter(Product::isAvailable).count());

        // Most popular products
        Map<String, Long> popularProducts = products.stream()
            .collect(Collectors.toMap(
                Product::getName,
                Product -> productRepository.findByProductName(product).stream()
                .filter(Product:isAvailable)
                .count()
            ));
            stats.setMostPopularProductS(popularProducts);
    }

     private void calculateRatingStatistics(ShopStatistics stats, Shop shop) {
        List<Review> allReviews = reviewRepository.findByProduceBoxFarmFarmer(shop.getSeller());

        // Average ratings
        stats.setAverageOverallRating(calculateAverageRating(allReviews, Review::getOverallRating));
        // Ratings by box
        Map<String, Double> ratingsByProduct = shop.getProducts().stream()
                .collect(Collectors.toMap(
                        Products::getName,
                        product -> calculateAverageRating(
                                reviewRepository.findByProductName(product),
                                Review::getOverallRating)));
        stats.setRatingsByProduct(ratingsByProduct);
    }

    private void calculateReviewStatistics(ShopStatistics stats, Farm farm) {
        List<Review> allReviews = reviewRepository.findByProductShopSeller(shop.getSeller());
        stats.setTotalReviews(allReviews.size());

        // Response rate
        long reviewsWithResponse = allReviews.stream()
                .filter(review -> review.getSellerResponse() != null)
                .count();
        stats.setResponseRate(allReviews.isEmpty() ? 0.0 : (double) reviewsWithResponse / allReviews.size() * 100);

        // Rating distribution
        Map<Double, Long> distribution = allReviews.stream()
                .collect(Collectors.groupingBy(
                        review -> review.getOverallRating(),
                        Collectors.counting()));
        stats.setRatingDistribution(distribution);
    }

    private double calculateAverageRating(List<Review> reviews,
            java.util.function.Function<Review, Double> ratingExtractor) {
        return reviews.stream()
                .mapToDouble(ratingExtractor::apply)
                .average()
                .orElse(0.0);
    }

}
