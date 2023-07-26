package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishForDeliveryDTO;
import com.bokafood.tbbackend.entity.Delivery;
import java.util.stream.Collectors;


/**
 * DeliveryMapper class used to map a Delivery to a DeliveryDTO and vice versa.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class DeliveryMapper {

    /**
     * Method to map a Delivery to a DeliveryDTO.
     * @param delivery The Delivery to be mapped.
     * @return The mapped DeliveryDTO.
     */
    static public DeliveryDTO toDTO(Delivery delivery) {
        return DeliveryDTO.builder()
            .id(delivery.getId())
            .userName(delivery.getUser().getUsername())
            .clientName(delivery.getClient().getName())
            .deliveryDate(delivery.getDeliveryDate())
            .build();
    }

    /**
     * Method to map a Delivery to a DeliveryWithDetailsDTO.
     * @param delivery The Delivery to be mapped.
     * @return The mapped DeliveryWithDetailsDTO.
     */
    static public DeliveryWithDetailsDTO toDTOWithDetails(Delivery delivery) {
        return DeliveryWithDetailsDTO.builder()
            .id(delivery.getId())
            .userName(delivery.getUser().getUsername())
            .clientName(delivery.getClient().getName())
            .deliveryDate(delivery.getDeliveryDate())
            .details(delivery.getDetails())

            .dishes(delivery.getDeliveryDishes().stream().map(dish -> DishForDeliveryDTO.builder()
                        .id(dish.getDish().getId())
                        .name(dish.getDish().getName())
                        .price(dish.getDish().getPrice())
                        .quantityRemained(dish.getQuantityRemained())
                        .quantityDelivered(dish.getQuantityDelivered())
                        .build()).collect(Collectors.toList()))
            .build();
    }

    /**
     * Method to map a DeliveryWithDetailsDTO to a Delivery.
     * @param deliveryWithDetailsDTO The DeliveryWithDetailsDTO to be mapped.
     * @return The mapped Delivery.
     */
    static public Delivery toDelivery(DeliveryWithDetailsDTO deliveryWithDetailsDTO) {
        return Delivery.builder()
            .id(deliveryWithDetailsDTO.getId())

            .deliveryDate(deliveryWithDetailsDTO.getDeliveryDate())
            .details(deliveryWithDetailsDTO.getDetails())
            .build();
    }

}
