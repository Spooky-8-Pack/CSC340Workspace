package com.example.spartanthrift.Seller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spartanthrift.shop.Shop;
import com.example.spartanthrift.shop.ShopService;

// @RestController
@Controller
@RequestMapping("/api/sellers")
public class SellerController {
    private final SellerService sellerService;
    private final ShopService shopService;

    public SellerController(SellerService sellerService, ShopService shopService) {
        this.sellerService = sellerService;
        this.shopService = shopService;
    }

    /**
     *  Displays the Seller + Shop registration form
     *  Creating a seller also creates a shop
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/createForm")
    public Object showCreateForm(Model model) {
        Seller seller = new Seller();
        model.addAttribute("seller", seller);
        model.addAttribute("title", "Create New Seller and Shop");
        return "seller/seller-shop-create"; // seller-shop-create.ftlh
    }

    /**
     *  Create a new seller with a shop
     *  Redirect to storefront
     * 
     * @param seller The seller to add
     * @return Shop storefront
     */
    @PostMapping("/create")
    public Object createSellerWithShop(@ModelAttribute Seller seller, 
                                    @RequestParam MultipartFile sellerImage, 
                                    @RequestParam String shopName,
                                    @RequestParam String description,
                                    @RequestParam String location,
                                    @RequestParam MultipartFile shopImage) {
        
        // Save seller
        Seller newSeller = sellerService.createSeller(seller, sellerImage);

        // Save shop
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setSeller(newSeller);
        shop.setDescription(description);
        shop.setLocation(location);

        shopService.createShop(newSeller, shop, shopImage);

        // Authenticate seller
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(newSeller, newSeller.getPassword(),
            newSeller.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);   

        // Redirect to storefront
        return "redirect:/api/sellers/" + newSeller.getId() + "/storefront";
    }

    /**
     *  Update form for Seller
     * 
     * @param id    The ID of the seller to update
     * @param model The model to add attributes to
     * @return      The view name for the update form
     */
    @GetMapping("/updateForm/{sellerId}")
    public String showUpdateForm(@PathVariable("sellerId") Long id, Model model) {
        Seller seller = sellerService.getSellerById(id);
        Shop shop = shopService.getShopBySellerId(id);

        model.addAttribute("seller", seller);
        model.addAttribute("shop", shop);
        model.addAttribute("title", "Update Seller: " + id);
        return "seller/seller-update"; // seller-update.ftlh
    }

    /**
     *  Endpoint to update a Seller 
     * 
     * @param id    The ID of the seller to update
     * @param seller    The updated seller 
     * @param image
     * @return      The updated seller object
     */
    // @PutMapping("/{id}")
    @PostMapping("/update/{id}")
    public Object updateSeller(@PathVariable Long id, Seller seller, @RequestParam MultipartFile image) {
        sellerService.updateSeller(id, seller, image);
        return "redirect:/sellers/" + id;
    }

    /**
     *  Endpoint to get a Seller by ID
     * 
     * @param id    The ID of the seller to retrieve
     * @param model  
     * @return      The seller with the matching ID
     */
    @GetMapping("/{id}")
    public String getSeller(@PathVariable Long id, Model model) { 
        model.addAttribute("seller", sellerService.getSellerById(id));
        model.addAttribute("title", "Seller #: " + id);
        return "seller/seller-details";
    }

    /**
     *  Display shop storefront
     * 
     * @param sellerId
     * @param model
     * @return
     */
    @GetMapping("/{id}/storefront")
    public String showStorefront(@PathVariable("id") Long sellerId, Model model) {
        Seller seller = sellerService.getSellerById(sellerId);
        Shop shop = shopService.getShopBySellerId(sellerId);

        model.addAttribute("seller", seller);
        model.addAttribute("shop", shop);
        model.addAttribute("products", shop.getProducts());
        model.addAttribute("title", seller.getName() + "'s Storefront");

        return "shop/storefront"; // storefront.ftlh
    }



}
