package com.bokafood.tbbackend.dto.deliveries;

import com.bokafood.tbbackend.dto.dishes.DishForDeliveryDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
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
