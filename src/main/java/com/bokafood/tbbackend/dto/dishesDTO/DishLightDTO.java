package com.bokafood.tbbackend.dto.dishesDTO;

import com.bokafood.tbbackend.entity.Dish;
import lombok.*;
import java.math.BigDecimal;


/**
 * DTO class used to transfer data from and to the Dish entity.
 * Used in the frontend to display dishes in the dish list.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
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
