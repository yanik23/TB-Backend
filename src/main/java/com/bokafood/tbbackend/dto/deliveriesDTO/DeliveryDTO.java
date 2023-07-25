package com.bokafood.tbbackend.dto.deliveriesDTO;

import lombok.*;

import java.time.LocalDateTime;


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
