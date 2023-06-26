package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.DeliveryDish;

import java.util.List;

public interface DeliveryDishService {
    List<DeliveryDish> getDeliveryDishes();
    DeliveryDish getDeliveryDishById(Long id);
    DeliveryDish addDeliveryDish(DeliveryDish deliveryDish);
    DeliveryDish updateDeliveryDish(Long id, DeliveryDish updatedDeliveryDish);
    void deleteDeliveryDish(Long id);

}
