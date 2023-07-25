package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import java.util.List;


public interface DeliveryDishService {
    List<DeliveryDish> getDeliveryDishes();
    DeliveryDish getDeliveryDishById(DeliveryDishId id);
    DeliveryDish addDeliveryDish(DeliveryDish deliveryDish);
    DeliveryDish updateDeliveryDish(DeliveryDishId id, DeliveryDish updatedDeliveryDish);
    List<DeliveryDish> findAllByDeliveryId(Long id);
    void deleteDeliveryDish(DeliveryDishId id);

}
