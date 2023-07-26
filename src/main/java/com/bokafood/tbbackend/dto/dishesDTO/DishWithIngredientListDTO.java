package com.bokafood.tbbackend.dto.dishesDTO;

import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientLessDTO;
import com.bokafood.tbbackend.entity.Dish;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * DTO class used to transfer data from and to the Dish entity.
 * Used in the frontend when clicking on a dish to show the details.
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
public class DishWithIngredientListDTO {
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

    List<IngredientLessDTO> ingredients;

}
