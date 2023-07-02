package com.bokafood.tbbackend.dto.dishes;


import com.bokafood.tbbackend.entity.Dish;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDTO {
    private Long id;
    private String name;
    private String description;
    private Dish.DishType currentType;
    private Dish.DishSize currentSize;
    private BigDecimal price;
    private boolean isAvailable;
    private int calories;
    private BigDecimal fats;
    private BigDecimal saturatedFats;
    private BigDecimal sodium;
    private BigDecimal carbohydrates;
    private BigDecimal fibers;
    private BigDecimal sugars;
    private BigDecimal proteins;
    private BigDecimal calcium;
    private BigDecimal iron;
    private BigDecimal potassium;

}
