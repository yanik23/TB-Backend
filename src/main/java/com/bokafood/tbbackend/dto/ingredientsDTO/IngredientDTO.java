package com.bokafood.tbbackend.dto.ingredientsDTO;

import com.bokafood.tbbackend.entity.Ingredient;
import lombok.*;

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


