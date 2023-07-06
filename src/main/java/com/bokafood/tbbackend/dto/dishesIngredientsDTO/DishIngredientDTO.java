package com.bokafood.tbbackend.dto.dishesIngredientsDTO;


import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishIngredientDTO {
    /*private Long id;
    private Long idDish;
    private Long idIngredient;*/
    DishIngredientId id;
    private Long idDish;
    private Long idIngredient;
    private BigDecimal weight;
}
