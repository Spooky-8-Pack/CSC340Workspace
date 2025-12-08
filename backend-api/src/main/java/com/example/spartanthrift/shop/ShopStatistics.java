package com.example.spartanthrift.Shop;

import java.math.BigDecimal;
import java.util.Map;

public class ShopStatistics {
    // Revenue Statistics
    private BigDecimal totalRevenue;
    private BigDecimal monthlyRevenue;
    private Map<String, BigDecimal> revenueByMonth;

    // Product Statistics
    private int totalProducts;
    private int availableProducts;
    private int productsSold;

    // Rating Statistics
    private Double averageOverallRating;

    // Review Statistics
    private long totalReviews;
    private double responseRate;
    private Map<Double, Long> ratingDistribution;

    public ShopStatistics() {
    }

    public ShopStatistics(BigDecimal totalRevenue, BigDecimal monthlyRevenue, Map<String, BigDecimal> revenueByMonth, int totalProducts, int availableProducts, int productsSold, 
        double averageOverallRating, long totalReviews, double responseRate, Map<Double, Long> ratingDistribution){
            this.totalRevenue = totalRevenue;
            this.monthlyRevenue = monthlyRevenue;
            this.revenueByMonth = revenueByMonth;
            this.totalProducts = totalProducts;
            this.availableProducts = availableProducts;
            this.totalProducts = totalProducts;
            this.productsSold = productsSold;
            this.averageOverallRating = averageOverallRating;
            this.totalReviews = totalReviews;
            this.responseRate = responseRate;
            this.ratingDistribution = ratingDistribution;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(BigDecimal monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(int availableProducts) {
        this.availableProducts = availableProducts;
    }

    public int getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(int productsSold) {
        this.productsSold = productsSold;
    }

    public Double getAverageOverallRating() {
        return averageOverallRating;
    }

    public void setAverageOverallRating(double averageOverallRating) {
        this.averageOverallRating = averageOverallRating;
    }

    public long getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(long totalReviews) {
        this.totalReviews = totalReviews;
    }

    public double getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(double responseRate) {
        this.responseRate = responseRate;
    }

    public Map<Double, Long> getRatingDistribution() {
        return ratingDistribution;
    }

    public void setRatingDistribution(Map<Double, Long> ratingDistribution) {
        this.ratingDistribution = ratingDistribution;
    }

    public Map<String, BigDecimal> getRevenueByMonth() {
        return revenueByMonth;
    }

    public void setRevenueByMonth(Map<String, BigDecimal> revenueByMonth) {
        this.revenueByMonth = revenueByMonth;
    }

}
