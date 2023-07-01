package com.bokafood.tbbackend.dto.clients;

import com.bokafood.tbbackend.dto.deliveries.DeliveryWithDetailsDTO;
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
