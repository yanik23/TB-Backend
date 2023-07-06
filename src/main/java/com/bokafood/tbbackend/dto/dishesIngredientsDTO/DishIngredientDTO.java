package com.bokafood.tbbackend.dto.dishesIngredientsDTO;


import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.entity.Ingredient;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishIngredientDTO {
    private DishIngredientId id;
    private Long idDish;
    private Long idIngredient;
    private BigDecimal weight;

    /*private DishIngredientId id;
    private Dish dish;
    private Ingredient ingredient;
    private BigDecimal weight;*/

}
