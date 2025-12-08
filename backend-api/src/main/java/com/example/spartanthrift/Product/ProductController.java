package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spartanthrift.shop.ShopService;

@RestController
public class ProductController {
    @Autowired
    private final ProductService productService;
    private final ShopService shopService;

    public ProductController(ProductService productService, ShopService shopService) {
        this.productService = productService;
        this.shopService = shopService;
    }
    
    //create a product
    @PostMapping("/products")
    public Object createProduct(@RequestBody Product product){
        return productService.createProduct(null, product);
    }

    //update product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    //delete product
    @DeleteMapping("/products/{id}")
    public Object deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }

    //get product by id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //get available products
    @GetMapping("/products/available")
    public Object getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    //get all products
    @GetMapping("/products")
    public Object getAllProducts(){
        return productService.getAllProducts();
    }

    //get by shop
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Product>> getProductsByShop(@PathVariable Long shopId) {
        return ResponseEntity.ok(productService.getProductsByShop(shopService.getShopById(shopId)));
    }
}
