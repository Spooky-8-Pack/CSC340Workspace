package com.example.spartanthrift.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spartanthrift.seller.Seller;

@Controller
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    /**
     * Method to get a shop by ID
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{shopId}")
    public String getShop(@PathVariable Long id, Model model) {
        model.addAttribute("shop", shopService.getShopById(id));
        model.addAttribute("title", "Shop #: " + id);
        return "shop/shop-details"; //Need to make this
    }

    /**
     *  Displays shop update form 
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateForm/{shopId}")
    public Object showUpdateForm(@PathVariable Long shopId, Model model) {
        Shop shop = shopService.getShopById(shopId);
        Seller seller = shop.getSeller();

        model.addAttribute("shop", shop);
        model.addAttribute("seller", seller);
        model.addAttribute("title", "Update Shop: " + shopId);
        return "shop/shop-update"; // shop-update.ftlh
    }

    /**
     * Endpoint to update a shop
     * 
     * @param id
     * @param image
     * @return      Redirects to the updated shop storefront
     */
    @PostMapping("/update/{id}") // Doesn't update the right fields yet
    public String updateShop(@PathVariable Long id, Shop shop, @RequestParam("shopImage") MultipartFile shopImage) {
        Shop updated = shopService.updateShop(id, shop, shopImage);
          
        return "redirect:/api/sellers/" + updated.getSeller().getId() + "/storefront";
    }


}