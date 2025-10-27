package com.example.spartanthrift.shop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.spartanthrift.seller.Seller;
// import com.example.spartanthrift.product.product; // Import for after merging to access the product class


import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @JsonIgnoreProperties("shop")
    private Seller seller;

    @NotBlank
    @Column(nullable = false)
    private String shopName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank
    private String location;

    // @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("shop")
    // private List<Product> products = new ArrayList<>();

}
