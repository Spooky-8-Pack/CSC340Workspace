package com.example.spartanthrift.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spartanthrift.Seller.Seller;
import com.example.spartanthrift.Seller.SellerService;

@Controller
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private final ShopService shopService;
    private final SellerService sellerService;

    public ShopController(ShopService shopService, SellerService sellerService) {
        this.shopService = shopService;
        this.sellerService = sellerService;
    }

    /**
     * Method to get a shop by ID
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String getShop(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.getShopById(id));
        model.addAttribute("title", "Shop #: " + id);
        return "shop-details"; //Need to make this
    }

    // Method to get all shops
    // @GetMapping
    // public ResponseEntity<List<Shop>> getAllShops() {
    //     return ResponseEntity.ok(shopService.getAllShops());
    // }

    /**
     *  Create a shop associated with a seller
     * 
     * @param sellerId
     * @param shop
     * @param shopImage
     * @return
     */    
    @PostMapping("/{sellerId}/shop")
    public Object createShop(@RequestParam Long sellerId, 
                                Shop shop, 
                                @RequestParam("shopImage") MultipartFile shopImage) {
        Seller seller = sellerService.getSellerById(sellerId);
        shopService.createShop(seller, shop, shopImage);

        return "redirect:/api/sellers/" + sellerId + "/shop";
    }

    /**
     *  Method to show update form
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/sellers/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Seller seller = sellerService.getSellerById(id);
        model.addAttribute("seller", seller);
        model.addAttribute("title", "Update Shop: " + id);
        return "shop-update"; // shop-update.ftlh
    }

    /**
     * Endpoint to update a shop
     * @param id
     * @param image
     * @return
     */
    @PutMapping("/{id}")
    public Object updateShop(@PathVariable Long id, Shop shop, @RequestParam("shopImage") MultipartFile shopImage) {
        shopService.updateShop(id, shop, shopImage);           
        return "redirect:/sellers/" + id;
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
    //     shopService.deleteShop(id);
    //     return ResponseEntity.ok().build();
    // }

}
