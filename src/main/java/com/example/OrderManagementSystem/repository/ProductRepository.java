package com.example.OrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagementSystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
} 
