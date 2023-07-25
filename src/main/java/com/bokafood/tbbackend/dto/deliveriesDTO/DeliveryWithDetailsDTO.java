package com.bokafood.tbbackend.dto.deliveriesDTO;

import com.bokafood.tbbackend.dto.dishesDTO.DishForDeliveryDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DeliveryWithDetailsDTO {
    private Long id;
    private String userName;
    private String clientName;
    private LocalDateTime deliveryDate;
    private String details;
    private List<DishForDeliveryDTO> dishes;
}
