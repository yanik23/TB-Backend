package com.bokafood.tbbackend.dto.dishes;

import com.bokafood.tbbackend.entity.Dish;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishLightDTO {
    private Long id;
    private String dishName;
    private Dish.DishType dishType;
    private Dish.DishSize dishSize;
    private BigDecimal price;
    private int calories;
    private boolean isAvailable;
}
