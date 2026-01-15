package com.example.OrderManagementSystem.dto;

public class OrderSummaryDTO {
    
    
    private Long orderId;
    private String orderStatus;

    public OrderSummaryDTO(Long orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

}
