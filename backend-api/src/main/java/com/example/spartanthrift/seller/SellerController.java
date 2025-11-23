package com.example.spartanthrift.Seller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
     *  Endpoint to show Seller registration form
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/sellers/createForm")
    public Object showCreateForm(Model model) {
        Seller seller = new Seller();
        model.addAttribute("seller", seller);
        model.addAttribute("title", "Create New Seller");
        return "seller-create"; // seller-create.ftlh
    }

    /**
     *  Create a new seller
     * 
     * @param seller The seller to add
     * @return List of all Sellers
     */
    @PostMapping
    public Object createSeller(Seller seller, 
                                    @RequestParam MultipartFile sellerImage, 
                                    @RequestParam MultipartFile shopImage) {
        Seller newSeller = sellerService.createSeller(seller, sellerImage);
        shopService.createShop(newSeller, seller.getShop(), shopImage);

        return "redirect:/sellers/" + newSeller.getSellerId();
    }

    /**
     *  Update form for Seller
     * 
     * @param id    The ID of the seller to update
     * @param model The model to add attributes to
     * @return      The view name for the update form
     */
    @GetMapping("/sellers/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Seller seller = sellerService.getSellerById(id);
        model.addAttribute("seller", seller);
        model.addAttribute("title", "Update Seller: " + id);
        return "seller-update"; //seller-update.ftlh
    }

    /**
     *  Endpoint ot update a Seller 
     * 
     * @param id    The ID of the seller to update
     * @param seller    The updated seller 
     * @param image
     * @return      The updated seller object
     */
    // @PutMapping("/{id}")
    @PostMapping("/sellers/update/{id}")
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
        return "seller-details";
    }

}
