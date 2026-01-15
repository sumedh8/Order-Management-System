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
public class CreateOderRequestDTO {

     private Long userId;
    private List<Long> productIds;
   
// public CreateOderRequestDTO(Long userId, List<Long> productIds){
// this.userId = userId;
//         this.productIds = productIds;
// }

}
