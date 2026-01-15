package com.example.OrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    
} 
