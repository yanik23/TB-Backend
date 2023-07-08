package com.bokafood.tbbackend.dto.dishes;

import com.bokafood.tbbackend.entity.Dish;
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
