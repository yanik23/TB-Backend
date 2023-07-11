package com.bokafood.tbbackend.dto.deliveries;

import com.bokafood.tbbackend.dto.dishes.DishForDeliveryDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime deliveryDate;
    private String details;
    private List<DishForDeliveryDTO> dishes;
}
