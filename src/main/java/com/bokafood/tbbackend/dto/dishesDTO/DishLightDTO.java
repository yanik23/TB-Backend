package com.bokafood.tbbackend.dto.dishesDTO;

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
    private String name;
    private Dish.DishType currentType;
    private Dish.DishSize currentSize;
    private BigDecimal price;
    private int calories;
    private boolean isAvailable;
}
