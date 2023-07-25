package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishForDeliveryDTO;
import com.bokafood.tbbackend.entity.Delivery;

import java.util.stream.Collectors;

public class DeliveryMapper {

    /*static public DeliveryWithDetailsDTO toDTO(Delivery delivery) {
        return DeliveryWithDetailsDTO.builder()
            .id(delivery.getId())
            .userName(ClientMapper.toDTO(delivery.getClient()))
            .deliveryDate(delivery.getDeliveryDate())
            .deliveryDetails(delivery.getDeliveryDetails())
            .build();
    }*/

    static public DeliveryDTO toDTO(Delivery delivery) {
        return DeliveryDTO.builder()
            .id(delivery.getId())
            .userName(delivery.getUser().getUsername())
            .clientName(delivery.getClient().getName())
            .deliveryDate(delivery.getDeliveryDate())
            .build();
    }

    /*static public DeliveryWithDetailsDTO toDTOWithDetails(Delivery delivery) {
        return DeliveryWithDetailsDTO.builder()
            .id(delivery.getId())
            .userName(delivery.getUser().getUsername())
            .clientName(delivery.getClient().getName())
            .deliveryDate(delivery.getDeliveryDate())
            .details(delivery.getDetails())
            //.quantityRemained(delivery.getQuantityRemained())
            //.quantityDelivered(delivery.getQuantityDelivered())
            .build();
    }*/

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

    //static public DishForDeliveryDTO


    /*static public Delivery toEntity(DeliveryWithDetailsDTO deliveryWithDetailsDTO) {
        return Delivery.builder()
            .id(deliveryWithDetailsDTO.getId())
            .user(UserMapper.toEntity(deliveryWithDetailsDTO.getUser()))
            .client(ClientMapper.toEntity(deliveryWithDetailsDTO.getClient()))
            .deliveryDate(deliveryWithDetailsDTO.getDeliveryDate())
            .deliveryDetails(deliveryWithDetailsDTO.getDeliveryDetails())
            .build();
    }*/


    static public Delivery toDelivery(DeliveryWithDetailsDTO deliveryWithDetailsDTO) {
        return Delivery.builder()
            .id(deliveryWithDetailsDTO.getId())
            //.user(UserMapper.toEntity(deliveryWithDetailsDTO.getUser()))
            //.client(ClientMapper.toEntity(deliveryWithDetailsDTO.getClient()))
            .deliveryDate(deliveryWithDetailsDTO.getDeliveryDate())
            .details(deliveryWithDetailsDTO.getDetails())
            .build();
    }

}
