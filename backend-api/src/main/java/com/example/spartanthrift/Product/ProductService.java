package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spartanthrift.shop.Shop;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //create a new product
    public Product createProduct(Product product){
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
