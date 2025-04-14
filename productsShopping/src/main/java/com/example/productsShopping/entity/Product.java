package com.example.productsShopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product marka is required")
    private String brand;

    @NotBlank(message = "Product model is required")
    private String model;

    @NotBlank(message = "Product category is required")
    private String category;

    @Column(columnDefinition = "TEXT")
    @NotNull(message = "Description can not be null")
    @Size(min = 1,max = 5000,message = "Decription must be between 1 to 5000 characters")
    private String description;

    @NotNull(message = "Price can not be null")
    @DecimalMin(value = "0",message = "Price must be at least 0")
    private String price;

    @NotNull(message = "Rate can not be null")
   @DecimalMin(value = "0",message = "Rate must be at least 0")
    @DecimalMax(value = "5",message = "Rate must be less than or equal to 5")
    private String rate;

    @Column(columnDefinition = "TEXT")
    @NotNull(message = "Image url can not be null")
    @Size(min = 1,max = 5000,message = "Image url must be between 1 to 5000 characters")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
