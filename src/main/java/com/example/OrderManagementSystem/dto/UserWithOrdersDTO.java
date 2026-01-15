package com.example.OrderManagementSystem.dto;

import java.util.List;

public class UserWithOrdersDTO {
     private Long userId;
    private String userName;
    private List<OrderSummaryDTO> orders;

     public UserWithOrdersDTO(Long userId, String userName,
                             List<OrderSummaryDTO> orders) {
        this.userId = userId;
        this.userName = userName;
        this.orders = orders;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<OrderSummaryDTO> getOrders() {
        return orders;
    }
}
