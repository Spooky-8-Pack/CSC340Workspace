package com.example.spartanthrift.Product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spartanthrift.Product.Product.ProductCategory;
import com.example.spartanthrift.Shop.Shop;
import com.example.spartanthrift.Shop.ShopService;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ShopService shopService;

    public ProductController(ProductService productService, ShopService shopService, ProductRepository productRepository) {
        this.productService = productService;
        this.shopService = shopService;
        this.productRepository = productRepository;
    }    
   /**
     * Add new product
     * 
     * @param shopId
     * @param product
     * @return
     */
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product,
                                @RequestParam Long shopId,
                                @RequestParam("productImages") List<MultipartFile> productImages) {
        Shop shop = shopService.getShopById(shopId);
        product.setShop(shop);

        productService.saveProduct(product, productImages);
        return "redirect:/api/sellers/" + shop.getSeller().getId() + "/storefront";
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

    /**
     * Display Featured and Categoried products on index page 
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        // Featured: take first 6 products
        List<Product> featuredProducts = productRepository.findTop6ByOrderByCreatedAtDesc();
        model.addAttribute("featuredProducts", featuredProducts);

        // Categories: full lists
        model.addAttribute("tops", productRepository.findByCategory(ProductCategory.TOPS));
        model.addAttribute("bottoms", productRepository.findByCategory(ProductCategory.BOTTOMS));
        model.addAttribute("dresses", productRepository.findByCategory(ProductCategory.DRESSES));
        model.addAttribute("shoes", productRepository.findByCategory(ProductCategory.SHOES));
        model.addAttribute("accessories", productRepository.findByCategory(ProductCategory.ACCESSORIES));
        model.addAttribute("headwear", productRepository.findByCategory(ProductCategory.HEADWEAR));

        return "index"; // index.html
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
