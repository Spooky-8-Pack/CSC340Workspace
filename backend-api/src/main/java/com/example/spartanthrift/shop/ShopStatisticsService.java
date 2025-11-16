package com.example.spartanthrift.shop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spartanthrift.Product.Product;
import com.example.spartanthrift.Product.ProductRepository;
import com.example.spartanthrift.Review.Review;
import com.example.spartanthrift.Review.ReviewRepository;
import com.example.spartanthrift.seller.SellerService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class ShopStatisticsService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final SellerService sellerService;

    public ShopStatisticsService(ShopRepository shopRepository, ProductRepository productRepository, ReviewRepository reviewRepository,
        SellerService sellerService) {
            this.shopRepository = shopRepository;
            this.productRepository = productRepository;
            this.reviewRepository = reviewRepository;
            this.sellerService = sellerService;
    }

    public ShopStatistics getShopStatistics(Long sellerId) {
        Shop shop = shopRepository.findBySeller(sellerService.getSellerById(sellerId)).orElseThrow(() -> new EntityNotFoundException("Shop not found"));
    
        ShopStatistics stats = new ShopStatistics();

        // Calculate product statistics
        calculateProductStatistics(stats, shop);

        // Calculate rating statistics
        calculateRatingStatistics(stats, shop);

        // Calculate review statistics
        calculateReviewStatistics(stats, shop);

        return stats;

    }

    /**
     *  Get product statistics (total products, total available products, total products sold)
     * @param stats
     * @param shop
     */
    private void calculateProductStatistics(ShopStatistics stats, Shop shop) {
        List<Product> products = productRepository.findByShop(shop);
        
        stats.setTotalProducts(products.size()); // get total products
        stats.setAvailableProducts((int) products.stream().filter(Product::isAvailable).count()); // get total available products
        stats.setProductsSold((int) products.stream().filter(p -> !p.isAvailable()).count()); // get total unavailable (sold) products
    }

    // Revenue Statistics
        // totalRevenue
        // monthlyRevenue
        // revenueByMonth

    public void calculateRevenueStatistics(ShopStatistics stats, Shop shop) {
        List<Product> soldProducts = productRepository.findByShopAndAvailable(shop, false);

        // Total revenue
        BigDecimal totalRevenue = soldProducts.stream()
            .map(Product::getPrice)
            .filter(price -> price != null)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        stats.setTotalRevenue(totalRevenue);

        // Monthly revenue

        Month currentMonth = LocalDate.now().getMonth();
        BigDecimal monthlyRevenue = soldProducts.stream()
            .filter(p -> p.getSoldDate() != null && p.getSoldDate().getMonth().equals(currentMonth))
            .map(Product::getPrice)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        stats.setMonthlyRevenue(monthlyRevenue);

        // Revenue by month (last 6 months)
        Map<String, BigDecimal> revenueByMonth = new LinkedHashMap<>();
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        for (int i = 5; i >= 0; i--) {
            LocalDate monthStart = LocalDate.now().minusMonths(i).withDayOfMonth(1);
            LocalDate monthEnd = monthStart.plusMonths(1);

            BigDecimal monthlyRev = soldProducts.stream()
                .filter(p -> p.getSoldDate() != null)
                .filter(p -> !p.getSoldDate().isBefore(monthStart) && p.getSoldDate().isBefore(monthEnd))
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            
            revenueByMonth.put(monthStart.format(monthFormatter), monthlyRev);
        }

        stats.setRevenueByMonth(revenueByMonth);

    }

    // Rating Statistics

    private void calculateRatingStatistics(ShopStatistics stats, Shop shop) {
        List<Review> reviews = reviewRepository.findByProductShopSeller(shop.getSeller());

        // Average ratings
        stats.setAverageOverallRating(calculateAverageRating(reviews, Review::getOverallRating));
        
    }

    private double calculateAverageRating(List<Review> reviews, java.util.function.Function<Review, Double> ratingExtractor) {
        return reviews.stream()
            .mapToDouble(ratingExtractor::apply)
            .average()
            .orElse(0.0);
    }

    
    // Review Statistics

    private void calculateReviewStatistics(ShopStatistics stats, Shop shop) {
       List<Review> reviews = reviewRepository.findByProductShopSeller(shop.getSeller());
       stats.setTotalReviews(reviews.size());

       // Response rate
       long reviewsWithResponse = reviews.stream()
            .filter(review -> review.getSellerResponse() != null)
            .count();
        
        stats.setResponseRate(reviews.isEmpty() ? 0.0 : (double) reviewsWithResponse / reviews.size() * 100);

        // Rating distribution
        Map<Double, Long> distribution = reviews.stream() 
            .collect(Collectors.groupingBy(
                review -> review.getOverallRating(),
                Collectors.counting()
            ));
        
            stats.setRatingDistribution(distribution);
        
    }


}
