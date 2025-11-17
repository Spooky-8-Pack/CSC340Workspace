package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spartanthrift.shop.Shop;
import com.example.spartanthrift.shop.ShopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private final ShopRepository shopRepository;

    public ProductService(ProductRepository productRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }

    /**
     * Add a new product and attach it to a shop
     * 
     * @param shopId
     * @param product
     * @return
     */
    public Product createProduct(Long shopId, Product product) {
        Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new IllegalStateException("Shop not found"));

        product.setShop(shop);
        return productRepository.save(product);
    }

    //update product
    public Product updateProduct(Long id, Product productDetails){
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product Not Found"));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setAvailable(productDetails.isAvailable());

        return productRepository.save(product);
    }

    //delete product
    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new EntityNotFoundException("Product Not Found");
        }
        productRepository.deleteById(id);
    }

    //get product by Id
    public Product getProductById(Long id){
        return productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product Not Found"));
    }

    //get all products
    public Object getAllProducts(){
        return productRepository.findAll();
    }

    //get available products
    public Object getAvailableProducts(){
        return productRepository.findByAvailable(true);
    }

    //get by seller goes here
    public List<Product> getProductsByShop(Shop shop) {
        return productRepository.findByShopAndAvailable(shop, true);
    }
}
