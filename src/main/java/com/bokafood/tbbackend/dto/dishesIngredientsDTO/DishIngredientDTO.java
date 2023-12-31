package com.bokafood.tbbackend.dto.dishesIngredientsDTO;


import com.bokafood.tbbackend.entity.DishIngredientId;
import lombok.*;
import java.math.BigDecimal;


/**
 * DTO class used to transfer data from and to the DishIngredient entity.
 */
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

}
