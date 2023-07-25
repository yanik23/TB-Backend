package com.bokafood.tbbackend.dto.dishesDTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishForDeliveryDTO {
    private Long id;
    private String name;
    /*private Dish.DishType currentType;
    private Dish.DishSize currentSize;*/
    private BigDecimal price;
    private int quantityRemained;
    private int quantityDelivered;

}
