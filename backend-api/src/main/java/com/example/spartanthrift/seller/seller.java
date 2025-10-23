package com.example.spartanthrift.seller;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "sellers") 
public class Seller {

    public Seller() {
    }

    public Seller(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name required")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name required")
    @Column(nullable = false)
    private String lastName;

    @Email
    @NotBlank(message = "Email required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password required")
    @Column(nullable = false) 
    private String password;
    
}
