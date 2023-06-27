package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> getDeliveries();
    Delivery getDeliveryById(Long id);
    Delivery addDelivery(Delivery delivery);
    Delivery updateDelivery(Long id, Delivery updatedDelivery);
    void deleteDelivery(Long id);

    List<Delivery> getDeliveriesByClientId(Long id);

}
