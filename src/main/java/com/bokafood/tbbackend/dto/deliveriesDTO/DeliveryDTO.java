package com.bokafood.tbbackend.dto.deliveriesDTO;

import lombok.*;
import java.time.LocalDateTime;


/**
 * DTO class used to transfer data from and to the Delivery entity.
 * Used to display in the deliveries list in the frontend.
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
public class DeliveryDTO {
    private Long id;
    private String userName;
    private String clientName;
    private LocalDateTime deliveryDate;
}
