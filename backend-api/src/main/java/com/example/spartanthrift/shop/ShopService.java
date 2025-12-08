package com.example.spartanthrift.Shop;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.spartanthrift.seller.Seller;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopService {
    private final ShopRepository shopRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/shop-images/";

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    /**
     *  Method to create a Shop associated with a Seller
     * 
     * @param seller
     * @param shop
     * @param shopImage
     * @return      The created shop
     */
    public Shop createShop(Seller seller, Shop shop, MultipartFile shopImage ) {
        // Check for duplicate shop name
        if (shopRepository.existsByShopName(shop.getShopName())) {
            throw new IllegalStateException("Shop name already exists");
        }

        // Associate a seller with a shop
        shop.setSeller(seller);
        
        // Save shopImage
        String originalFileName = shopImage.getOriginalFilename();
        if (originalFileName != null && originalFileName.contains(".")) {
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            String fileName = seller.getId() + "-shop." + fileExtension;
            saveFile(shopImage, fileName);
            shop.setShopImagePath(fileName);
        } else {
            shop.setShopImagePath("No_Image_Available.png");
        }
        
        // Return new Shop
        return shopRepository.save(shop);
    }

    /**
     *  Helper function to save image file paths
     * 
     * @param file
     * @param fileName
     */
    public void saveFile(MultipartFile file, String fileName) {
        try(InputStream inputStream = file.getInputStream()) {
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.createDirectories(filePath.getParent());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Update shop information
     * 
     * @param id
     * @param shop
     * @param shopImage
     * @return
     */
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public Shop updateShop(Long id, Shop shop, MultipartFile shopImage) {
        Shop existingShop = shopRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Shop not found"));

        // Copy over updated fields
        existingShop.setShopName(shop.getShopName());
        existingShop.setDescription(shop.getDescription());
        existingShop.setLocation(shop.getLocation());

        // Handle shopImage
        String originalFileName = shopImage.getOriginalFilename();

        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(id) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = shopImage.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                existingShop.setShopImagePath(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shopRepository.save(existingShop);
    }

    public void deleteShop(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
        Seller seller = shop.getSeller();

        if(seller != null) {
            seller.setShop(null);
        }
        shopRepository.delete(shop);
    }

    /**
     *  Get shop by ID
     * @param id
     * @return
     */
    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shop not found"));
    }

    public Shop getShopBySeller(Seller seller) {
        return shopRepository.findBySeller(seller).orElseThrow(() -> new IllegalArgumentException("Shop not found"));
    }

    public Shop getShopBySellerId(Long id) {
        return shopRepository.findBySellerId(id).orElseThrow(() -> new IllegalArgumentException("Shop not found"));

    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

}
