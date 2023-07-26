package com.bokafood.tbbackend.dto.deliveriesDTO;

import com.bokafood.tbbackend.dto.dishesDTO.DishForDeliveryDTO;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * DTO class used to transfer data from and to the Delivery entity.
 * Used to display when clicking on a delivery to show the details in the frontend.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
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
