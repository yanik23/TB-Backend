package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.deliveriesDishes.DeliveryDishDTO;
import com.bokafood.tbbackend.dto.dishes.DishForDeliveryDTO;
import com.bokafood.tbbackend.entity.DeliveryDish;

public class DeliveryDishMapper {

    static public DeliveryDishDTO toDTO(DeliveryDish deliveryDish) {
        com.bokafood.tbbackend.dto.deliveriesDishes.DeliveryDishDTO dto = new com.bokafood.tbbackend.dto.deliveriesDishes.DeliveryDishDTO();
        dto.setId(deliveryDish.getId());
        dto.setDelivery(deliveryDish.getDelivery());
        dto.setDish(deliveryDish.getDish());
        dto.setQuantityRemained(deliveryDish.getQuantityRemained());
        dto.setQuantityDelivered(deliveryDish.getQuantityDelivered());
        return dto;
    }

    static public DeliveryDish toEntity(DeliveryDishDTO deliveryDishDTO) {
        DeliveryDish entity = new DeliveryDish();
        entity.setId(deliveryDishDTO.getId());
        entity.setDelivery(deliveryDishDTO.getDelivery());
        entity.setDish(deliveryDishDTO.getDish());
        entity.setQuantityRemained(deliveryDishDTO.getQuantityRemained());
        entity.setQuantityDelivered(deliveryDishDTO.getQuantityDelivered());
        return entity;
    }

    static public DishForDeliveryDTO toDishForDeliveryDTO(DeliveryDish deliveryDish) {
        DishForDeliveryDTO dto = new DishForDeliveryDTO();
        dto.setId(deliveryDish.getDish().getId());
        dto.setName(deliveryDish.getDish().getName());
        dto.setPrice(deliveryDish.getDish().getPrice());
        dto.setQuantityRemained(deliveryDish.getQuantityRemained());
        dto.setQuantityDelivered(deliveryDish.getQuantityDelivered());
        return dto;
    }


}
