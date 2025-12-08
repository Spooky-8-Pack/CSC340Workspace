package com.example.spartanthrift.Product;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spartanthrift.Seller.Seller;
import com.example.spartanthrift.User.User;
import com.example.spartanthrift.User.UserRepository;
import com.example.spartanthrift.shop.Shop;
import com.example.spartanthrift.shop.ShopService;

@Controller
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired 
    private final UserRepository userRepository;

    private final ShopService shopService;

    public ProductController(ProductService productService, ShopService shopService,
        UserRepository userRepository, ProductRepository productRepository) {
        this.productService = productService;
        this.shopService = shopService;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    
<<<<<<< HEAD
    //create a product
    @PostMapping("/products")
    public Object createProduct(@RequestBody Product product){
        return productService.createProduct(null, product);
=======
    /**
     * Createw new Product
     * 
     * @param product
     * @param principal
     * @return  The refreshed storefront with added product
     */
    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product, Principal principal){
        String email = principal.getName();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (user instanceof Seller seller) {
            Shop shop = seller.getShop();
            product.setShop(shop);
            productRepository.save(product);
        }
        return "redirect:/storefront";
>>>>>>> 620178c4a708580ca03cba99888399d16414d4da
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
