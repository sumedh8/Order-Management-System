package com.example.OrderManagementSystem.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderWithProductsDTO<ProductInOrderDTO> {
     private Long orderId;
    private String orderStatus;
    private List<ProductInOrderDTO> products;
}
