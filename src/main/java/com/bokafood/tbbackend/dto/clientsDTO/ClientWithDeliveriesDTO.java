package com.bokafood.tbbackend.dto.clientsDTO;

import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientWithDeliveriesDTO {

    private ClientDTO client;
    private List<DeliveryWithDetailsDTO> deliveries;
}
