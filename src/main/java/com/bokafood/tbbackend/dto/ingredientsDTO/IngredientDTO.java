package com.bokafood.tbbackend.dto.ingredientsDTO;

import com.bokafood.tbbackend.entity.Ingredient;
import lombok.*;


/**
 * DTO class used to transfer data from and to the Ingredient entity.
 * Used to display in the ingredients list and the details in the frontend.
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
public class IngredientDTO {
    private Long id;
    private String name;
    private Ingredient.IngredientType currentType;
    private String description;
    private String supplier;
}


