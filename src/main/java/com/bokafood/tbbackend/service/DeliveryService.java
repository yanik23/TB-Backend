package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.deliveries.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveries.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDTO> getDeliveries();
    DeliveryWithDetailsDTO getDeliveryById(Long id);
    DeliveryDTO addDelivery(DeliveryWithDetailsDTO deliveryWithDetailsDTO);
    DeliveryDTO updateDelivery(Long id, DeliveryDTO updatedDeliveryWithDetailsDTO);
    void deleteDelivery(Long id);

    //List<Delivery> getDeliveriesByClientId(Long id);

}
