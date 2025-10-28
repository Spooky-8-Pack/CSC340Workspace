package com.example.spartanthrift.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    //create a product
    @PostMapping("/create")
    public Object createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    //update product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    //delete product
    @DeleteMapping("/{id}")
    public Object deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }

    //get product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //get available products
    @GetMapping("/available")
    public Object getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    //get all products
    @GetMapping("/all")
    public Object getAllProducts(){
        return productService.getAllProducts();
    }

    //get by seller goes here
}
