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
public class OrderResponseDTO {
    
       private Long orderId;
    private String orderStatus;
    private String userName;
    private List<String> productNames;


   
    // public OrderResponseDTO(Long orderId,String orderStatus,
    //                         String userName, List<String> productNames)
    //                         {
    //         this.orderId = orderId;
    //     this.orderStatus = orderStatus;
    //     this.userName = userName;
    //     this.productNames = productNames;
    // }
}
