package com.example.OrderManagementSystem.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.example.OrderManagementSystem.dto.CreateOderRequestDTO;
import com.example.OrderManagementSystem.dto.OrderResponseDTO;
import com.example.OrderManagementSystem.dto.OrderWithProductsDTO;
import com.example.OrderManagementSystem.dto.ProductsInOrderDTO;
//import com.example.OrderManagementSystem.dto.OrderWithProductsDTO;
import com.example.OrderManagementSystem.entity.Order;
import com.example.OrderManagementSystem.entity.Product;
import com.example.OrderManagementSystem.entity.User;

import com.example.OrderManagementSystem.repository.OrderRepository;
import com.example.OrderManagementSystem.repository.ProductRepository;
import com.example.OrderManagementSystem.repository.UserRepository;

//import lombok.RequiredArgsConstructor;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
    
    private final UserRepository userRepo;
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(UserRepository userRepo,
         OrderRepository orderRepo,
         ProductRepository productRepo){
                this.userRepo = userRepo;
                this.productRepo = productRepo;
                this.orderRepo = orderRepo;
    }

    public OrderResponseDTO createOrder(CreateOderRequestDTO request) {

        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Product> products = productRepo.findAllById(request.getProductIds());

       Order order = new Order();
        order.setOrderStatus("CREATED");
        order.setUser(user);
        order.setProducts(products);

        Order savedOrder = orderRepo.save(order);

        // Convert Entity → DTO
        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(savedOrder.getId());
        response.setOrderStatus(savedOrder.getOrderStatus());
        response.setUserName(user.getName());
        response.setProductNames(
                products.stream()
                        .map(Product::getName)
                        .collect(Collectors.toList())
        );

        return response;
    }
@Transactional(readOnly = true)
    public List<OrderWithProductsDTO> getOrdersByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getOrders().stream()
                .map(order -> new OrderWithProductsDTO(
                        order.getId(),
                        order.getOrderStatus(),
                        order.getProducts().stream()
                                .map(p -> new ProductsInOrderDTO(
                                        p.getId(),
                                        p.getName(),
                                        p.getPrice()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
  
  
  
  
            }




  

    
}
