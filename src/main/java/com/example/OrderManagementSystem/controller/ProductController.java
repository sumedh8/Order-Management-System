package com.example.OrderManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderManagementSystem.dto.ProductResponseDTO;
import com.example.OrderManagementSystem.entity.Product;
import com.example.OrderManagementSystem.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE PRODUCT
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // GET ALL PRODUCTS
@GetMapping
public List<ProductResponseDTO> getAllProducts() {
    return productRepository.findAll()
            .stream()
            .map(p -> new ProductResponseDTO(
                    p.getId(),
                    p.getName(),
                    p.getPrice()
            ))
            .toList();
}
}
