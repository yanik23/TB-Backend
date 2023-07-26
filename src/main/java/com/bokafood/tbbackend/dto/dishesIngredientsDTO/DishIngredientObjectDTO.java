package com.bokafood.tbbackend.dto.dishesIngredientsDTO;

import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.entity.Ingredient;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishIngredientObjectDTO {
    private DishIngredientId id;
    private Dish dish;
    private Ingredient ingredient;
    private BigDecimal weight;

}
