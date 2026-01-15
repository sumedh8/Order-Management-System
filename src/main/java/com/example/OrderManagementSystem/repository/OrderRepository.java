package com.example.OrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagementSystem.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    
} 
