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
    private String dishName;
    private BigDecimal price;
    private Dish.DishSize dishSize;
    private Dish.DishType dishType;
}
