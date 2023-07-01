package com.bokafood.tbbackend.dto.deliveries;

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
    private LocalDateTime deliveryDate;
    private List<DishLightDTO> dishes;
}
