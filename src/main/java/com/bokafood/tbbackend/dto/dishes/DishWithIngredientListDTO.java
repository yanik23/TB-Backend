package com.bokafood.tbbackend.dto.dishes;

import com.bokafood.tbbackend.dto.ingredients.IngredientLessDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DishWithIngredientListDTO {
    private String dishName;
    private BigDecimal price;
    private int calories;

    List<IngredientLessDTO> ingredients;

}
