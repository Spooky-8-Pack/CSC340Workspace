package com.example.spartanthrift.Product;


// File I/O
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

// Lists
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spartanthrift.Shop.Shop;
import com.example.spartanthrift.Shop.ShopService;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequestMapping("/api/products")
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final ShopService shopService;

    // File path for product images
    private static final String UPLOAD_DIR = "src/main/resources/static/products/";

    /**
     * Contructor 
     * 
     * @param productRepository
     * @param shopService
     */
    public ProductService(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    /**
     * Save product
     * 
     * @param product
     * @param productImages
     * @return
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public Product saveProduct(Product product, List<MultipartFile> productImages) {
        List<String> paths = new ArrayList<>();

        int count = 0;
        for (MultipartFile file : productImages) {
            if(!file.isEmpty() && count < 10) {
                // Create unique file name
                String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR, fileName);

                // Ensure directory exists
                try {
                    Files.createDirectories(filePath.getParent());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Save file
                try {
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Add path to list
                paths.add(fileName);
                count++;
            }
        }
        product.setImagePaths(paths);
        return productRepository.save(product);
    }

    /**
     * Update product 
     * 
     * @param id
     * @param productDetails
     * @return
     */
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

    /**
     * Get list of all products
     * @return
     */
    public List<Product> getAllProducts(){
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
