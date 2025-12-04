package com.example.spartanthrift.Seller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class SellerService {
    private final SellerRepository sellerRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/seller-images/";

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    /**
     * Method to add a new Seller
     * @param seller The seller to add
     * @return
     */
    public Seller createSeller(Seller seller, MultipartFile sellerImage) {
        // Creating seller in sellerRepository
        Seller newSeller = sellerRepository.save(seller); 

        // Storing sellerImage
        String originalFileName = sellerImage.getOriginalFilename();

        try {
            if (originalFileName != null & originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(newSeller.getId()) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = sellerImage.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                newSeller.setSellerImagePath(fileName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Save and return new Seller
        return sellerRepository.save(newSeller);
    }

    /**
     *  Method to update a Seller
     * @param sellerId      The ID of the seller to update 
     * @param seller        The seller to update 
     * @param sellerImage
     * @return      The updated seller object
     */
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public Seller updateSeller(Long sellerId, Seller seller, MultipartFile sellerImage) {
        String originalFileName = sellerImage.getOriginalFilename();

        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(sellerId) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = sellerImage.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                seller.setSellerImagePath(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sellerRepository.save(seller);
    }

    /**
     *  Helper function to save image file paths
     * 
     * @param file
     * @param fileName
     */
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
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
     * Method to get Seller by email
     * 
     * @param email
     * @return
     */
    public Seller getSellerByEmail(@PathVariable String email) {
        return sellerRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }

    /**
     *  Method to get Seller by ID
     * @param sellerId  The ID of the seller to retrieve
     * @return          The seller with the specified ID
     */
    public Seller getSellerById(@PathVariable long sellerId) {
        return sellerRepository.findById(sellerId).orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    }
}
