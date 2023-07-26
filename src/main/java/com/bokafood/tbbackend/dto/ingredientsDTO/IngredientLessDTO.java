package com.bokafood.tbbackend.dto.ingredientsDTO;


import lombok.*;
import java.math.BigDecimal;


/**
 * DTO class used to transfer data from and to the Ingredient entity.
 * Used to display the ingredients for a dish in the frontend.
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
public class IngredientLessDTO {
    Long id;
    private String name;
    private BigDecimal weight;


    /*public IngredientLessDTO(String ingredientName, BigDecimal weight) {
        this.ingredientName = ingredientName;
        this.weight = weight;
    }*/
}
