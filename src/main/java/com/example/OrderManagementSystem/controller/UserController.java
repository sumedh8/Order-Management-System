package com.example.OrderManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderManagementSystem.dto.OrderSummaryDTO;
import com.example.OrderManagementSystem.dto.OrderWithProductsDTO;
import com.example.OrderManagementSystem.dto.UserResponseDTO;
import com.example.OrderManagementSystem.dto.UserWithOrdersDTO;
import com.example.OrderManagementSystem.entity.User;
import com.example.OrderManagementSystem.repository.UserRepository;
import com.example.OrderManagementSystem.service.OrderService;

//import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")

public class UserController {
     private final UserRepository userRepository;
         private final OrderService orderService;



public UserController(UserRepository userRepository, OrderService orderService) {
    this.userRepository = userRepository;
    this.orderService = orderService;
}


       @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // GET ALL USERS
 @GetMapping
public List<UserResponseDTO> getAllUsers() {
    return userRepository.findAll()
            .stream()
            .map(u -> new UserResponseDTO(u.getId(), u.getName()))
            .toList();
}

    @GetMapping("/{id}")
public User getUserById(@PathVariable Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
}

@GetMapping("/with-orders")
public List<UserWithOrdersDTO> getUsersWithOrders() {

    return userRepository.findAll().stream().map(user -> {

        List<OrderSummaryDTO> orderDTOs =
                user.getOrders().stream()
                        .map(order -> new OrderSummaryDTO(
                                order.getId(),
                                order.getOrderStatus()
                        ))
                        .toList();

        return new UserWithOrdersDTO(
                user.getId(),
                user.getName(),
                orderDTOs
        );

    }).toList();
}

@GetMapping("{userId}/orders")
public List<OrderWithProductsDTO> getUserOrders(
        @PathVariable Long userId) {
    return orderService.getOrdersByUser(userId);
}




}
