package com.example.OrderManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderManagementSystem.dto.CreateOderRequestDTO;
import com.example.OrderManagementSystem.dto.OrderResponseDTO;
//import com.example.OrderManagementSystem.dto.UserResponseDTO;
//import com.example.OrderManagementSystem.entity.Order;
//import com.example.OrderManagementSystem.entity.User;
import com.example.OrderManagementSystem.service.OrderService;

//import java.util.List;

//import org.springframework.web.bind.annotation.GetMapping;

//import java.util.List;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController (OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrderResponseDTO createOrder(
        @RequestBody CreateOderRequestDTO request) {
         return orderService.createOrder(request);
    }



}
